package br.com.correios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.com.correios.dto.BuscaLogBairroDTO;
import br.com.correios.repository.BuscaLogBairroRepository;

@Controller
@RequestMapping("/buscaLogBairro")
public class BuscaLogBairroController {
    
	@Autowired
	private BuscaLogBairroRepository buscaLogBairroRepository;
	
	@GetMapping
	public String buscaLogBairro() {
		return "BuscaLogBairro";
	}
	@GetMapping(value="/buscaLocalidadeporBairro")
	public ModelAndView resultadoBuscaLogBairro(@RequestParam ("UF") String UF,@RequestParam ("localidade") String localidade,@RequestParam ("bairro") String bairro, RedirectAttributes attributes) {
		List<BuscaLogBairroDTO> buscaLogBairros = buscaLogBairroRepository.buscaPorNomeLogBairro(UF,localidade, bairro);
		
		if(UF.equals("")) {
			ModelAndView mv = new ModelAndView("redirect:/buscaLogBairro");
			attributes.addFlashAttribute("mensagem", " O CAMPO DE BUSCA É OBRIGATORIO");
			return mv;
		}		
		if(localidade.equals("")) {
			ModelAndView mv = new ModelAndView("redirect:/buscaLogBairro");
			attributes.addFlashAttribute("mensagem", " O CAMPO DE BUSCA É OBRIGATORIO");
			return mv;
		}		
		if(bairro.equals("")) {
			ModelAndView mv = new ModelAndView("redirect:/buscaLogBairro");
			attributes.addFlashAttribute("mensagem", " TODOS OS CAMPOS DE BUSCAS SÃO OBRIGATORIOS");
			return mv;
		}					
		ModelAndView mv = new ModelAndView("ResultadoBuscaBairro");
		mv.addObject("buscaLogBairros", buscaLogBairros);
		
		if(buscaLogBairros.isEmpty()) {
			mv.addObject("mensagem","A busca não retornou dados!");
		}else {
			mv.addObject("mensagem","Dados encontrados com sucesso!");			
		}
		
		return mv;
		
	}
	
}
