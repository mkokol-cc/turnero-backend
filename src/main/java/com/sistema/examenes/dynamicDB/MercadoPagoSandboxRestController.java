package com.sistema.examenes.dynamicDB;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.GsonBuilder;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.sistema.examenes.modelo.mios.AsignacionRecursoTipoTurno;
import com.sistema.examenes.repositorios.mios.AsignacionRecursoTipoTurnoRepository;

@RestController
@CrossOrigin("*")
public class MercadoPagoSandboxRestController {
	
	@Autowired
	private AsignacionRecursoTipoTurnoRepository asignacionRepo;
	
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PreferenceService preferenceService;

    public MercadoPagoSandboxRestController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @PostMapping(value = "/mp/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPreference(
            @RequestBody NewPreferenceDTO preferenceDTO
            ) throws MPException {
        return this.preferenceService.create(preferenceDTO);
    }
    
    
    
    @GetMapping(value="/mp/createAndRedirect/{id}")
    public String createAndRedirect(@PathVariable int id) throws MPException, JsonProcessingException{
    	AsignacionRecursoTipoTurno a = asignacionRepo.getById((long)id);
    	Preference preference = new Preference();
    	preference.setBackUrls(
    		/*
    		new BackUrls().setFailure("http://localhost:8080/mp/failure")
    		.setPending("http://localhost:8080/mp/pending")
    		.setSuccess("http://localhost:8080/mp/success")
    		*/
        	new BackUrls().setFailure("http://localhost:4200/payment-failure")
        	.setPending("http://localhost:4200/payment-pending")
       		.setSuccess("http://localhost:4200/payment-success")
    	);
    	Item item = new Item();
    	item.setTitle("Seña "+a.getTipoTurno().getNombre()+" - "+a.getRecurso().getNombre())
    	.setQuantity(1).setUnitPrice((float)(a.getSeniaCtvos()/100))
    	.setDescription(a.getTipoTurno().getDescripcion()+" - "+a.getRecurso().getDescripcion())
    	.setCurrencyId("ARS");
    	preference.appendItem(item);
    	var result = preference.save();
    	//System.out.println(result.getSandboxInitPoint());
    	//return "redirect"+result;
    	ObjectMapper mapper = new ObjectMapper();
    	ObjectNode link = JsonNodeFactory.instance.objectNode();
    	link.put("link", result.getSandboxInitPoint());
    	String json = mapper.writeValueAsString(link);
	    return json;
    }
    
    @GetMapping(value="/mp/success")
    public String success(HttpServletRequest request,
            @RequestParam("collection_id") String collectionId,
            @RequestParam("collection_status") String collectionStatus,
            @RequestParam("external_reference") String externalReference,
            @RequestParam("payment_type") String paymentType,
            @RequestParam("merchant_order_id") String merchantOrderId,
            @RequestParam("preference_id") String preferenceId,
            @RequestParam("site_id") String siteId,
            @RequestParam("processing_mode") String processingMode,
            @RequestParam("merchant_account_id") String merchantAccountId,
            Model model
    		)throws MPException {
    	var payment = Payment.findById(collectionId);
    	System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(payment));
    	model.addAttribute("payment",payment);
    	return "ok";
    }
    
    @GetMapping(value="/mp/failure")
    public String failure(HttpServletRequest request,
            @RequestParam("collection_id") String collectionId,
            @RequestParam("collection_status") String collectionStatus,
            @RequestParam("external_reference") String externalReference,
            @RequestParam("payment_type") String paymentType,
            @RequestParam("merchant_order_id") String merchantOrderId,
            @RequestParam("preference_id") String preferenceId,
            @RequestParam("site_id") String siteId,
            @RequestParam("processing_mode") String processingMode,
            @RequestParam("merchant_account_id") String merchantAccountId,
            Model model
    		)throws MPException {
    	var payment = Payment.findById(collectionId);
    	System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(payment));
    	model.addAttribute("payment",payment);
    	return "no ok";
    }
    
    
    
}
