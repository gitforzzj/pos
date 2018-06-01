package com.z4group.pos.service;

import java.util.List;

import com.z4group.pos.domain.TableStatus;

public interface ITableStatusService {

	TableStatus findById(Integer i);

	List<TableStatus> findAll();

}
