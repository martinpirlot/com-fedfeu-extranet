package com.fedfeu.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

public class ResultController implements Serializable {
	private static final long serialVersionUID = 8214731597235854357L;
	
	@Autowired
    private DatabaseController databaseController;
}
