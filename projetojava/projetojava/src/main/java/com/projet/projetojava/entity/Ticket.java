package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String passportNumber;
    private String cpf;
    private String rg;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (isCpfValid(cpf)) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("CPF inválido");
		}
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		if (isRgValid(rg)) {
			this.rg = rg;
		} else {
			throw new IllegalArgumentException("RG inválido");
		}
	}

    public boolean isCpfValid(String cpf) {
        // Implemente a lógica de validação do CPF aqui
        return cpf != null && cpf.length() == 11 && cpf.chars().allMatch(Character::isDigit);
    }

    public boolean isRgValid(String rg) {
        // Implemente a lógica de validação do RG aqui
        return rg != null && rg.length() >= 5 && rg.length() <= 14 && rg.chars().allMatch(Character::isLetterOrDigit);
    }
}
