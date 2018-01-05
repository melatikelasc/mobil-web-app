/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.melati.mobilwebapp.controller;

/**
 * Lanny Nadia Liu (15090099)
 * Indri Novi R. (15090036)
 * Waldi Agustiarno (14090028)
 */

import lab.melati.mobilwebapp.entity.Mobil;
import lab.melati.mobilwebapp.repo.MobilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Syeh,Kukuh,Aji,Desprianto
 */

@Controller
public class AppController {
    @Autowired
    private MobilRepo mblRepo;
    
    @RequestMapping("/home")
    public void index() {}
    
    @RequestMapping("/daftar-mobil")
    public void getDaftarMobil(Model model) {
        model.addAttribute("daftarMobil",mblRepo.findAll());
    }
    
        @RequestMapping(value = "/tambah-data" , method = RequestMethod.GET)
    public void getFormTambahData(
    	@ModelAttribute("mbl") Mobil mbl, 
    	BindingResult result ) {}

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.POST)
    public String simpanData(
    	@ModelAttribute("mbl") Mobil mbl, BindingResult result) {

    	System.out.println("ID : " + mbl.getId());
    	System.out.println("No. Polisi : " + mbl.getNopol());
    	System.out.println("Merk Tipe : " + mbl.getMerk_tipe());
    	mblRepo.save(mbl);
    	return "redirect:daftar-mobil";
    }
    
    @RequestMapping(value = "/edit-data", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "id", required =
    false) String id,
        @ModelAttribute("mbl") Mobil mobil, BindingResult
        binding) {
        Mobil mbl = mblRepo.findOne(id);
        mobil.setId(mbl.getId());
        mobil.setNopol(mbl.getNopol());
        mobil.setMerk_tipe(mbl.getMerk_tipe());
    }
 
    @RequestMapping(value = "/edit-data",
    method = RequestMethod.POST)
    public String saveEditData(
        @ModelAttribute("mbl") Mobil mbl,
        BindingResult binding) {
        mblRepo.save(mbl);
        return "redirect:/daftar-mobil";
    }
    
    @RequestMapping("/delete")
    public String deleteData(
        @RequestParam(name = "id", required = true) String id) {
        mblRepo.delete(id);
        return "redirect:/daftar-mobil";
    }
    

}
