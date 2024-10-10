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

}
