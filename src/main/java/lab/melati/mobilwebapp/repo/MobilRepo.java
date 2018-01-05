/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.melati.mobilwebapp.repo;

import lab.melati.mobilwebapp.entity.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Lanny Nadia Liu (15090099)
 * Indri Novi R. (15090036)
 * Waldi Agustiarno (14090028)
 */
@Repository

public interface MobilRepo

	extends JpaRepository<Mobil,String> {}