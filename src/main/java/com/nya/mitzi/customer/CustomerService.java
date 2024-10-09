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
        System.out.println("customer name: "+customer.getFirstName());
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
        System.out.println("customer added"+'\n');
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

        System.out.println("customer updated"+'\n');
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


/*public Customer addCustomer(Customer customer) throws CustomerException{//todo fix so doesnt contain id
    this.isUnique(customer);
    if(customer.getPassword().length() == 0 || customer.getEmail().length() == 0 || customer.getFirstName().length() == 0){
        throw new CustomerException(ErrorMessage.MISSING_DETAILS);
    }
    return this.customerRepo.save(customer);
}

    public Customer addCustomer(Customer customer) throws CustomerException {//todo fix so doesnt contain id
        if(!this.isUnique(customer)){
            return null;
            //throw new CustomerException(ErrorMessage.CUSTOMER_NOT_UNIQUE);
        }
        if((customer.getPassword()==null) || (customer.getEmail()==null) || (customer.getFirstName()==null)){
            System.out.println("password: "+customer.getPassword());
            System.out.println("email: "+customer.getEmail());
            System.out.println("firstName: "+customer.getFirstName());
            System.out.println("missing details");
            return null;
            //throw new CustomerException(ErrorMessage.MISSING_DETAILS);
        }//todo fix
        return this.customerRepo.save(customer);
    }

    public Customer getCustomer(int id) throws CustomerException {
        return this.customerRepo.findById(id).orElseThrow(()->new CustomerException
                (ErrorMessage.ID_NOT_EXIST));
    }

    public List<Customer> getCustomerList(){
        return this.customerRepo.findAll();
    }

    /*public void updateCustomer(int id,Customer customer) throws CustomerException {
        this.isUnique(customer);
        customer.setId(id);
        customerRepo.save(customer);
    }
    public void updateCustomer(int id, Customer customer) throws CustomerException {
        System.out.println("hi from update customer");
        if (!this.customerRepo.existsById(id)) {
            //throw new CustomerException(ErrorMessage.ID_NOT_EXIST);
            return;
        }
        System.out.println("id exists");
        if (this.customerRepo.existsByEmail(customer.getEmail())) {
            Customer otherCustomer = this.customerRepo.findByEmail(customer.getEmail());
            if (otherCustomer.getId() != id) {
                System.out.println("email not unique");
                return;
                //throw new CustomerException(ErrorMessage.EMAIL_EXIST);
            }
        }//todo improve
        System.out.println("email unique");
        if (this.customerRepo.existsByFirstName(customer.getFirstName())) {
            Customer customer1 = this.customerRepo.findByFirstName(customer.getFirstName());
            if (customer1.getId() != id) {
                //throw new CustomerException(ErrorMessage.NAME_EXIST);
            return;
            }
        }//todo improve
        System.out.println("first name unique"+'\n');

        System.out.println(customer.getFirstName()!=null);
        System.out.println(customer.getEmail()!=null);
        System.out.println(customer.getPassword()!=null);

        boolean isUpdate=true;

        if(this.customerRepo.existsByEmail(customer.getEmail())){
            Customer otherCustomer=this.customerRepo.findByEmail(customer.getEmail());
            if(otherCustomer.getId()!=id){
                System.out.println("email not unique");
                return;
                //throw new CustomerException(ErrorMessage.EMAIL_EXIST);
            }
        }


        if(customer.getEmail()==null||customer.getPassword()==null||customer.getFirstName()==null
                || customer.getEmail().isEmpty() || customer.getPassword().isEmpty() || customer.getFirstName().isEmpty()){
            System.out.println("missing details");
            return;//todo add exception
        }

        if((customer.getFirstName()!=null)&&(customer.getEmail()!=null)&&(customer.getPassword()!=null)){
            customer.setId(id);
            customerRepo.save(customer);
        }
        else {
        }
    }


        public void deleteCustomer(int id) throws CustomerException {
        if(!this.customerRepo.existsById(id)){
            //throw new CustomerException(ErrorMessage.ID_NOT_EXIST);
            return;
        }
        this.customerRepo.deleteById(Math.toIntExact(id));
    }

    public boolean isUnique(Customer customer) throws CustomerException {
        if(this.customerRepo.existsById(customer.getId())){
            //throw new CustomerException(ErrorMessage.ID_ALREADY_FOUND);
            return false;
        }
        if(this.customerRepo.existsByEmail(customer.getEmail())){
            //throw new CustomerException(ErrorMessage.EMAIL_EXIST);
            return false;
        }
        if(this.customerRepo.existsByFirstName(customer.getFirstName())){
            //throw new CustomerException(ErrorMessage.NAME_EXIST);
            return false;
        }
        return true;
    }*/

    public boolean isExist(Customer customer) {
        return this.customerRepo.existsByEmailAndPassword(customer.getEmail(),customer.getPassword());
    }

}

