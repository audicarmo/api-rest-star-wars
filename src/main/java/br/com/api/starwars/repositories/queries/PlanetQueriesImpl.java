package br.com.api.starwars.repositories.queries;

import br.com.api.starwars.constants.MongoConstants;
import br.com.api.starwars.entities.Planet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.StringUtils;

import javax.management.Query;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PlanetQueriesImpl  implements PlanetQueries {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Planet> getPlanetsAll(final String name, final String climate, final Long ground,
                                      Pageable pageable) {
        Query query = new Query();

        if (!StringUtils.isEmpty(name)) {
            query.addCriteria(Criteria.where("name")
            )                         .regex(name, "i");
        }

        if (!StringUtils.isEmpty(climate)) {
            query.addCriteria(Criteria.where("climate")
            )                         .regex(climate, "i");
        }

        if (!StringUtils.isEmpty(ground)) {
            query.addCriteria(Criteria.where("ground")
                                        .regex(ground, "i"));
        }

        if (pageable.getSort()
                    .isUnsorted()) {
            query.with(Sort.by(Sort.Direction.DESC, MongoConstants.NAME));
        }

        query.with(pageable);

        long count = mongoTemplate.count(query, Planet.class);

        List<Planet> result = mongoTemplate.find(query, Planet.class);

        return new PageImpl<>(result, pageable, count);
    }
}
