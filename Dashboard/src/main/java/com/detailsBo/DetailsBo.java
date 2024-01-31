package com.detailsBo;

import java.util.List;


import modules.Patientinfo;

public interface DetailsBo {
	int save(Patientinfo p);
	int delete(int patientId);
	int delete(Patientinfo p);
	int update(Patientinfo p);
	Patientinfo get(int patientId);
	List<Patientinfo> getAll();

}
