package com.DAO;

import com.model.Aggregator;
import com.model.HorizontalAggregator;
import com.model.VerticalAggregator;
import com.utils.XMLConverter;
import com.utils.XMLListWrapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Roman Zayats on 26.03.2015.
 */
@Repository("AggregatorDAO")
@Transactional
public class AggregatorDAOImpl extends HibernateDaoSupport implements AggregatorDAO {

    private XMLConverter<Aggregator> converter =
            new XMLConverter<>(VerticalAggregator.class, HorizontalAggregator.class, XMLListWrapper.class);

    @Value("${aggregator.config.path}")
    private String CONFIG_PATH;

    @Autowired
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public List<Aggregator> getAggregators() {
        return converter.doUnmarshall(CONFIG_PATH);
    }
}