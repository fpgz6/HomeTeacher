package com.jiajiaohello.core.account.dao;

import com.jiajiaohello.core.account.model.ManagerAccount;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Manager: bohan
 * Date: 9/17/14
 * Time: 3:01 PM
 */
@Repository
public class ManagerAccountDaoImpl implements ManagerAccountDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public void saveOrUpdate(ManagerAccount account) {
        hibernateTemplate.saveOrUpdate(account);
    }

    @Override
    public ManagerAccount get(ManagerAccount account) {
        List<ManagerAccount> list = list(account, 0, 1);
        if(CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public ManagerAccount get(Integer id) {
        return hibernateTemplate.get(ManagerAccount.class, id);
    }

    @Override
    public List<ManagerAccount> list(ManagerAccount account) {
        return hibernateTemplate.findByExample(account);
    }

    @Override
    public List<ManagerAccount> list(ManagerAccount account, int firstResult, int maxResult) {
        return hibernateTemplate.findByExample(account, firstResult, maxResult);
    }
}
