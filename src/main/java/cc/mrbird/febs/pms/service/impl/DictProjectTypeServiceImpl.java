package cc.mrbird.febs.pms.service.impl;

import cc.mrbird.febs.pms.entity.DictProjectType;
import cc.mrbird.febs.pms.mapper.DictProjectTypeMapper;
import cc.mrbird.febs.pms.service.DictProjectTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pangPython
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictProjectTypeServiceImpl extends ServiceImpl<DictProjectTypeMapper, DictProjectType> implements DictProjectTypeService {
}
