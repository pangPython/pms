package cc.mrbird.febs.pms.service.impl;

import cc.mrbird.febs.pms.entity.DictProjectStage;
import cc.mrbird.febs.pms.mapper.DictProjectStageMapper;
import cc.mrbird.febs.pms.service.DictProjectStageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pangPython
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictProjectStageServiceImpl extends ServiceImpl<DictProjectStageMapper, DictProjectStage> implements DictProjectStageService {
}
