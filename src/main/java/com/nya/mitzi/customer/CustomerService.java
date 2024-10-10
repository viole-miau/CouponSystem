package com.nya.mitzi.customer;

import com.nya.mitzi.enum1.ErrorMessage;
import com.nya.mitzi.exception.CustomerException;
import com.nya.mitzi.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    private CustomerValidator customerValidator;

    public Customer addCustomer(Customer customer)throws CustomerException {
        /*
        errors:
            1.name
                1.null
                2.empty
                3.not unique
            2.email
                1.null
                2.empty
                3.not unique
            3.password
                1.null
                2.empty
        */
        //1.1, 1.2, 2.1, 2.2, 3.1, 3.2
        if((customer.getFirstName()==null|| customer.getFirstName().isEmpty())||
                (customer.getEmail()==null|| customer.getEmail().isEmpty())||
                (customer.getPassword()==null|| customer.getPassword().isEmpty())){
            throw new CustomerException(ErrorMessage.MISSING_DETAILS);
        }
        //1.3
        if(this.customerRepo.existsByFirstName(customer.getFirstName())){
            throw new CustomerException(ErrorMessage.NAME_EXIST);
        }
        //2.3
        if(this.customerRepo.existsByEmail(customer.getEmail())){
            throw new CustomerException(ErrorMessage.EMAIL_EXIST);
        }
        return this.customerRepo.save(customer);
    }

    public void updateCustomer(int id, Customer customer) throws CustomerException {
              /*
        errors:
            1.id not exist
            2.name
                1.null
                2.empty
                3.not unique
            3.email
                1.null
                2.empty
                3.not unique
            4.password
                1.null
                2.empty
        */
        //1.
        if (!this.customerRepo.existsById(id)) {
            throw new CustomerException(ErrorMessage.ID_NOT_EXIST);
        }
        customer.setId(id);
        //2.1, 2.2, 3.1, 3.2, 4.1, 4.2
        if((customer.getFirstName()==null|| customer.getFirstName().isEmpty())||
                (customer.getEmail()==null|| customer.getEmail().isEmpty())||
                (customer.getPassword()==null|| customer.getPassword().isEmpty())){
            throw new CustomerException(ErrorMessage.MISSING_DETAILS);
        }
        //2.3
        //System.out.println("Customer EXISTS BY NAME"+(this.customerRepo.existsByName(customer.getName())));
        //System.out.println("customer name: "+customer.getName());
        //System.out.println("find by name: "+this.customerRepo.findByName(customer.getName()));
        if(this.customerRepo.existsByFirstName(customer.getFirstName())){
            this.isUniqueByName(customer);
            //System.out.println("NAME EXISTS");
        }
        if(this.customerRepo.existsByEmail(customer.getEmail())){
            this.isUniqueByName(customer);
            //System.out.println("NAME EXISTS");
        }

        //3.3
        //if(this.customerRepo.existsByName(customer.getName())){
        //  this.isUniqueByName(customer);
        //}
        this.customerRepo.save(customer);
    }

    public void deleteCustomer(int id) throws CustomerException {
                      /*
        errors:
            1.id not exist
        */
        //1.
        if(!this.customerRepo.existsById(id)) {
            throw new CustomerException(ErrorMessage.ID_NOT_EXIST);//todo fix
        }
        System.out.println("customer deleted"+'\n');
        this.customerRepo.deleteById(id);
    }

    public Customer getCustomer(int id) throws CustomerException {
        /*
        errors:
            1.id not exist
        */
        //1.
        return this.customerRepo.findById(id).orElseThrow(()->new CustomerException
                (ErrorMessage.ID_NOT_EXIST));
    }

    public List<Customer> getCustomerList(){
        return this.customerRepo.findAll();
    }

    //////
    //used in update func
    public boolean isUniqueByName(Customer customer) throws CustomerException {

        int id=customer.getId();
        Customer customer1=this.customerRepo.findByFirstName(customer.getFirstName()).orElseThrow(()->new CustomerException
                (ErrorMessage.SOMETHING_IS_WRONG));
        int id1=customer1.getId();//todo merge with former

        if(id==id1){
            return true;
        }
        throw new CustomerException(ErrorMessage.NAME_EXIST);
    }

    public boolean isUniqueByEmail(Customer customer) throws CustomerException {

        int id=customer.getId();
        Customer customer1=this.customerRepo.findByEmail(customer.getEmail()).orElseThrow(()->new CustomerException
                (ErrorMessage.SOMETHING_IS_WRONG));
        int id1=customer1.getId();//todo merge with former

        if(id==id1){
            return true;
        }
        throw new CustomerException(ErrorMessage.NAME_EXIST);
    }


    public boolean isExist(Customer customer) {
        return this.customerRepo.existsByEmailAndPassword(customer.getEmail(),customer.getPassword());
    }

}

