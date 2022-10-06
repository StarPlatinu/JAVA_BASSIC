package com.training.main;

import java.io.IOException;

import com.training.utils.Validation;

public class Main {
	public static void main(String[] args) {
        try {
			Validation.getMain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
