package com.example.lab4_20200825.controlers;

import com.example.lab4_20200825.entidad.Employee;
import com.example.lab4_20200825.repository.EmpleadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PrincipalControler {
    final EmpleadoRepository empleadoRepository;

    public PrincipalControler(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
    @GetMapping(value = {"/list", ""})
    public String listar(Model model) {
        List<Employee> listaempleados = empleadoRepository.findAll();
        model.addAttribute("lista1", listaempleados);
        return "list";
    }
    @GetMapping("/edit")
    public String editarempleado(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optShipper = empleadoRepository.findById(id);
        if (optShipper.isPresent()) {
            Employee employee = optShipper.get();
            model.addAttribute("employee", employee);
            return "editFrm";
        } else {
            return "redirect:/list";
        }
    }
    @PostMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam("searchField") String searchField, Model model) {

        //List<Shipper> lista =  shipperRepository.findByCompanyName(searchField);
        List<Employee> lista = empleadoRepository.buscarPorNombre(searchField);
        // aca de pone ambos ya que solo 1 de ambos se va a presionar entonces se debe tern el mismo nombre
        // de lista para que lo pueda leer en la vista
        model.addAttribute("lista1", lista);
        model.addAttribute("textoBuscado", searchField);

        return "list";
    }

}
