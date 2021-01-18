package com.yoooho.mall.service.Impl;

import cn.hutool.core.util.ObjectUtil;
import com.yoooho.mall.domian.LocalStorage;
import com.yoooho.mall.common.utils.FileUtil;
import com.yoooho.mall.service.dto.LocalStorageDTO;
import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.SecurityUtils;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.convert.LocalStorageDao;
import com.yoooho.mall.repository.LocalStorageRepository;
import com.yoooho.mall.service.LocalStorageService;
import com.yoooho.mall.service.dto.LocalStorageQueryCriteria;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "localStorage")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LocalStorageServiceImpl implements LocalStorageService {

    private final LocalStorageRepository localStorageRepository;

    private final LocalStorageDao localStorageDao;

    @Value("${file.path}")
    private String path;

    @Value("${file.maxSize}")
    private long maxSize;

    public LocalStorageServiceImpl(LocalStorageRepository localStorageRepository, LocalStorageDao localStorageDao) {
        this.localStorageRepository = localStorageRepository;
        this.localStorageDao = localStorageDao;
    }

    @Override
    @Cacheable
    public Object queryAll(LocalStorageQueryCriteria criteria, Pageable pageable) {
        Page<LocalStorage> page = localStorageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(localStorageDao::toDto));
    }

    @Override
    @Cacheable
    public List<LocalStorageDTO> queryAll(LocalStorageQueryCriteria criteria) {
        return localStorageDao.toDto(localStorageRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder)));
    }

    @Override
    @Cacheable(key = "#p0")
    public LocalStorageDTO findById(Long id) {
        LocalStorage localStorage = localStorageRepository.findById(id).orElseGet(LocalStorage::new);
        ValidationUtil.isNull(localStorage.getId(), "LocalStorage", "id", id);
        return localStorageDao.toDto(localStorage);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public LocalStorageDTO create(String name, MultipartFile multipartFile) {
        FileUtil.checkSize(maxSize, multipartFile.getSize());
        String suffix = FileUtil.getExtensionName(multipartFile.getOriginalFilename());
        String type = FileUtil.getFileType(suffix);
        File file = FileUtil.upload(multipartFile, path + type + File.separator);
        if (ObjectUtil.isNull(file)) {
//                throw new BadRequestException("上传失败");
        }
        try {
            name = StringUtils.isBlank(name) ? FileUtil.getFileNameNoEx(multipartFile.getOriginalFilename()) : name;
            LocalStorage localStorage = new LocalStorage(
                    file.getName(),
                    name,
                    suffix,
                    file.getPath(),
                    type,
                    FileUtil.getSize(multipartFile.getSize()),
                    SecurityUtils.getUsername()
            );
            return localStorageDao.toDto(localStorageRepository.save(localStorage));
        } catch (Exception e) {
            FileUtil.del(file);
            throw e;
        }
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(LocalStorage resources) {
        LocalStorage localStorage = localStorageRepository.findById(resources.getId()).orElseGet(LocalStorage::new);
        ValidationUtil.isNull(localStorage.getId(), "LocalStorage", "id", resources.getId());
        localStorage.copy(resources);
        localStorageRepository.save(localStorage);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            LocalStorage storage = localStorageRepository.findById(id).orElseGet(LocalStorage::new);
            FileUtil.del(storage.getPath());
            localStorageRepository.delete(storage);
        }
    }

    @Override
    public void download(List<LocalStorageDTO> queryAll, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LocalStorageDTO localStorageDTO : queryAll) {
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("文件名", localStorageDTO.getRealName());
            map.put("备注名", localStorageDTO.getName());
            map.put("文件类型", localStorageDTO.getType());
            map.put("文件大小", localStorageDTO.getSize());
            map.put("操作人", localStorageDTO.getOperate());
            map.put("创建日期", sdf.format(localStorageDTO.getCreateTime()));
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
