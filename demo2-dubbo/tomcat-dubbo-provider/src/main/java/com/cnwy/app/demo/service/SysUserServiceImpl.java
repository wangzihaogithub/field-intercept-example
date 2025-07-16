package com.cnwy.app.demo.service;

import com.cnwy.app.demo.annotation.CnwyFieldConsumer;
import com.cnwy.app.demo.entity.SysUser;
import com.cnwy.app.demo.enums.StringConstants;
import com.cnwy.app.demo.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

@Service(StringConstants.SYS_USER)
public class SysUserServiceImpl extends AbstractCrudService<SysUserMapper, SysUser, Long> {

}
