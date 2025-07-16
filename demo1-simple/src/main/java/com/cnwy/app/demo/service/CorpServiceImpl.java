package com.cnwy.app.demo.service;

import com.cnwy.app.demo.enums.StringConstants;
import com.cnwy.app.demo.entity.Corp;
import com.cnwy.app.demo.mapper.CorpMapper;
import org.springframework.stereotype.Service;

@Service(StringConstants.CORP)
public class CorpServiceImpl extends AbstractCrudService<CorpMapper, Corp, String> {

}
