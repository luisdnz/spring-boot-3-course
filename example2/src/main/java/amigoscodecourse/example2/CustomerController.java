package amigoscodecourse.example2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    

    private final CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

    @GetMapping
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}

    static record NewCustomerResquest(String name, String email, Integer age){

	}
	@PostMapping
	public void addCustomer(@RequestBody NewCustomerResquest request){
		Customer customer = new Customer();
		customer.setName(request.name);
		customer.setEmail(request.email);
		customer.setAge(request.age);
		customerRepository.save(customer);

	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id){
		if(customerRepository.existsById(id)){
			customerRepository.deleteById(id);
		}		
	}

	@PutMapping("{customerId}")
	public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerResquest request){
		if(customerRepository.existsById(id)){
			Customer customer = customerRepository.getReferenceById(id);
			customer.setName(request.name);
			customer.setEmail(request.email);
			customer.setAge(request.age);
			customerRepository.save(customer);
		}
	}
}
