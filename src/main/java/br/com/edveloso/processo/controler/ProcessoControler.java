package br.com.edveloso.processo.controler;

import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.edveloso.processo.entidade.Processo;
import br.com.edveloso.processo.service.ProcessoService;


@Controller
@Component
@RequestMapping("processo")
public class ProcessoControler {

	private static final String PROCESSO = "/processo";

	private static final String LISTA = PROCESSO+"/list";

	private static final String NEW = PROCESSO+"/form";
	
	@Autowired
	private ProcessoService processoService; 
	  
	@RequestMapping
	public String get(Model model){
		List<Processo> processos = processoService.listar();
		model.addAttribute("processos", processos);
		return LISTA; 
	}
	
	@RequestMapping("/new") 
	public String create(Model model){
		model.addAttribute("processo", new Processo());
		return NEW;
	}
	
	
	@RequestMapping("/tarefa") 
	public String tarefa(Model model){
		model.addAttribute("processo", new Processo());
		return "tarefa/form";
	}
	
	
 
	@RequestMapping("/complete") 
	public String complete(Model model){
		model.addAttribute("jbpmVariable", "completo");
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("sample.bpmn"), ResourceType.BPMN2);
		KnowledgeBase knowledgeBase = kbuilder.newKnowledgeBase();
        StatefulKnowledgeSession ksession = knowledgeBase.newStatefulKnowledgeSession();
        ProcessInstance processInstance = ksession.startProcess("com.sample.bpmn");
		
        return "redirect:/processo";
	}
	
	
	@RequestMapping("/save") 
	public String save(@ModelAttribute(PROCESSO)  Processo processo,Model model ){
		processoService.salvar(processo);
		return "redirect:/processo";
	}
	
	@RequestMapping("/edit/{id}") 
	public String edit(@PathVariable Integer id,Model model ){
		Processo processo = processoService.getProcesso(id);
		model.addAttribute("processo", processo);
		return NEW;
	}
	
	@RequestMapping("/update") 
	public String update(@ModelAttribute(PROCESSO) Processo processo,Model model ){
		processoService.update(processo);
		return "redirect:/processo";
	}

	@RequestMapping("/delete/{id}") 
	public String delete(@PathVariable Integer id, Model model){
		processoService.delete(id);
		return "redirect:/processo";
	}
	
	
	public ProcessoService getProcessoService() {
		return processoService;
	}

	public void setProcessoService(ProcessoService processoService) {
		this.processoService = processoService;
	}
	
	
	
	
	
}
