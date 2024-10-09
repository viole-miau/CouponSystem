package com.nya.mitzi.company;

import com.nya.mitzi.enum1.ErrorMessage;
import com.nya.mitzi.exception.CompanyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public Company addCompany(Company company)throws CompanyException {
        System.out.println("company name: "+company.getName());
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
        if((company.getName()==null|| company.getName().isEmpty())||
                (company.getEmail()==null|| company.getEmail().isEmpty())||
                (company.getPassword()==null|| company.getPassword().isEmpty())){
            throw new CompanyException(ErrorMessage.MISSING_DETAILS);
        }
        //1.3
        if(this.companyRepo.existsByName(company.getName())){
            throw new CompanyException(ErrorMessage.NAME_EXIST);
        }
        //2.3
        if(this.companyRepo.existsByEmail(company.getEmail())){
            throw new CompanyException(ErrorMessage.EMAIL_EXIST);
        }
        System.out.println("company added"+'\n');
        return this.companyRepo.save(company);
    }

    public void updateCompany(int id, Company company) throws CompanyException {
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
        if (!this.companyRepo.existsById(id)) {
            throw new CompanyException(ErrorMessage.ID_NOT_EXIST);
        }
        company.setId(id);
        //2.1, 2.2, 3.1, 3.2, 4.1, 4.2
        if((company.getName()==null|| company.getName().isEmpty())||
                (company.getEmail()==null|| company.getEmail().isEmpty())||
                (company.getPassword()==null|| company.getPassword().isEmpty())){
            throw new CompanyException(ErrorMessage.MISSING_DETAILS);
        }
        //2.3
        //System.out.println("COMPANY EXISTS BY NAME"+(this.companyRepo.existsByName(company.getName())));
        //System.out.println("company name: "+company.getName());
        //System.out.println("find by name: "+this.companyRepo.findByName(company.getName()));
        if(this.companyRepo.existsByName(company.getName())){
            this.isUniqueByName(company);
            //System.out.println("NAME EXISTS");
        }
        if(this.companyRepo.existsByEmail(company.getEmail())){
            this.isUniqueByName(company);
            //System.out.println("NAME EXISTS");
        }

        //3.3
        //if(this.companyRepo.existsByName(company.getName())){
          //  this.isUniqueByName(company);
        //}

        System.out.println("company updated"+'\n');
        this.companyRepo.save(company);
    }

    public void deleteCompany(int id) throws CompanyException {
                      /*
        errors:
            1.id not exist
        */
        //1.
        if(!this.companyRepo.existsById(id)) {
            throw new CompanyException(ErrorMessage.ID_NOT_EXIST);//todo fix
        }
        System.out.println("company deleted"+'\n');
        this.companyRepo.deleteById(id);
    }

    public Company getCompany(int id) throws CompanyException {
        /*
        errors:
            1.id not exist
        */
        //1.
        return this.companyRepo.findById(id).orElseThrow(()->new CompanyException
                (ErrorMessage.ID_NOT_EXIST));
    }

    public List<Company> getCompanyList(){
        return this.companyRepo.findAll();
    }

    //////
    //used in update func
    public boolean isUniqueByName(Company company) throws CompanyException {

        int id=company.getId();
        Company company1=this.companyRepo.findByName(company.getName()).orElseThrow(()->new CompanyException
                (ErrorMessage.SOMETHING_IS_WRONG));
        int id1=company1.getId();//todo merge with former

        if(id==id1){
            return true;
        }
        throw new CompanyException(ErrorMessage.NAME_EXIST);
    }

    public boolean isUniqueByEmail(Company company) throws CompanyException {

        int id=company.getId();
        Company company1=this.companyRepo.findByEmail(company.getEmail()).orElseThrow(()->new CompanyException
                (ErrorMessage.SOMETHING_IS_WRONG));
        int id1=company1.getId();//todo merge with former

        if(id==id1){
            return true;
        }
        throw new CompanyException(ErrorMessage.NAME_EXIST);
    }

/*    public Company addCompany(Company company) throws CompanyException{//todo fix so doesnt contain id
        if(!this.isUnique(company)){
            throw new CompanyException(ErrorMessage.COMPANY_NOT_UNIQUE);
        }
        if(company.getPassword().isEmpty() || company.getEmail().isEmpty() || company.getName().isEmpty()){
            System.out.println("missing details");
            throw new CompanyException(ErrorMessage.MISSING_DETAILS);
        }//todo fix
        return this.companyRepo.save(company);
    }

    public Company getCompany(int id) throws CompanyException {
        return this.companyRepo.findById(id).orElseThrow(
                ()->new CompanyException(ErrorMessage.ID_NOT_EXIST));
    }

    public List<Company> getCompanyList(){
        return this.companyRepo.findAll();
    }

    public void updateCompany(int id, Company company) throws CompanyException {

        if(!this.companyRepo.existsById(id)){
            throw new CompanyException(ErrorMessage.ID_NOT_EXIST);
        }

        if(this.companyRepo.existsByEmail(company.getEmail())){
            Company otherCompany=this.companyRepo.findByEmail(company.getEmail());
            if(otherCompany.getId()!=id){
                System.out.println("email not unique");
                return;
                //throw new CompanyException(ErrorMessage.EMAIL_EXIST);
            }
        }//todo improve

        if(this.companyRepo.existsByName(company.getName())){
            Company company1=this.companyRepo.findByName(company.getName());
            if(company1.getId()!=id){
                throw new CompanyException(ErrorMessage.NAME_EXIST);
            }
        }//todo improve

        if(company.getEmail()==null||company.getPassword()==null||company.getName()==null
                || company.getEmail().isEmpty() || company.getPassword().isEmpty() || company.getName().isEmpty()){
            System.out.println("missing details");
            return;//todo add exception
        }

        company.setId(id);
        this.companyRepo.save(company);
    }

    public void deleteCompany(int id) throws CompanyException {
        if(!this.companyRepo.existsById(id)){
            throw new CompanyException(ErrorMessage.ID_NOT_EXIST);
        }
        this.companyRepo.deleteById(id);
    }

    public boolean isUnique(Company company) throws CompanyException {
        System.out.println("hi from is unique");
        if(this.companyRepo.existsById(company.getId())){
            System.out.println("ERROR: ID");
            throw new CompanyException(ErrorMessage.ID_ALREADY_FOUND);
        }
        if(this.companyRepo.existsByName(company.getName())){
            System.out.println("ERROR: NAME");
            throw new CompanyException(ErrorMessage.COMPANY_NAME_EXIST);
        }//todo fix
        if(this.companyRepo.existsByEmail(company.getEmail())){
            System.out.println("ERROR: EMAIL");
            throw new CompanyException(ErrorMessage.EMAIL_EXIST);
        }//todo fix
        return true;
    }

    public boolean isExist(Company company) {
        return this.companyRepo.existsByEmailAndPassword(company.getEmail(),company.getPassword());
    }

    public boolean existById(Company company){
        //System.out.println("hi from company service-> exist by id");
        //System.out.println("result: "+result);
        return this.companyRepo.existsById(company.getId());
    }*/



}
