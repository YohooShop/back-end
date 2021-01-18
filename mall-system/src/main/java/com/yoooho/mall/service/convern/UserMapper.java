package com.yoooho.mall.service.convern;


import com.yoooho.mall.domain.User;
import com.yoooho.mall.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


/**
 * @author Zheng Jie
 * @date 2019-11-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDTO, User> {

    /**
     * 转换
     * @param user 原始数据
     * @return /
     */
    @Override
//    @Mapping(source = "user.userAvatar.realName",target = "avatar")
    UserDTO toDto(User user);
}
