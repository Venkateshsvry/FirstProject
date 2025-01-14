package com.hr.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hr.model.DatabaseSequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {
	@Autowired
    MongoOperations mongoOperations;

	@Autowired
	public SequenceGeneratorService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public String generateSequence(String seqName) {

		DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
			      new Update().inc("seq",1), options().returnNew(true).upsert(true),
			      DatabaseSequence.class);
		int i= (int)(!Objects.isNull(counter) ? counter.getSeq() : 1);
		String s=Integer.toString(i);
			    return s;

	}
}