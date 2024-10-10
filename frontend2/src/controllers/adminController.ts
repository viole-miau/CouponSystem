import BaseController from "./BaseController";
import Company from "../models/Company";
import Customer from "../models/Customer";

//sends queries to server

export default class AdminController extends BaseController {
  constructor() {
    const baseUrl: string = "admin/";
    super(baseUrl);
  }

  async addCompany(company: Omit<Company, "id">): Promise<boolean> {
    try {
      const response = await this.instance.post("addCompany", company);
      if (response.status == 200) {
        return true;
      } else {
        return false;
      }
    } catch (err) {
      throw err;
    }
  }

  async updateCompany(company: Company) {
    try {
      const response = await this.instance.put(
        `updateCompany/${company.id}`,
        company
      );
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async deleteCompany(company: Company) {
    try {
      const response = await this.instance.delete(
        `deleteCompany/${company.id}`
      );
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async getCompany(company: Pick<Required<Company>, "id">): Promise<void> {
    try {
      const companyData = (
        await this.instance.get<Company>(`getCompany/${company.id}`)
      ).data;
      console.log(companyData);
    } catch (err) {
      console.error(err);
    }
  }

  async getAllCompanies(): Promise<Company[]> {
    try {
      const companiesData = (
        await this.instance.get<Company[]>("getAllCompanies")
      ).data;
      return companiesData;
    } catch (err) {
      throw err;
    }
  }

  async addCustomer(customer: Omit<Customer, "id" | "coupons">) {
    try {
      const response = await this.instance.post("addCustomer", {
        firstName: customer.firstName,
        lastName: customer.lastName,
        email: customer.email,
        password: customer.password,
      });
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async updateCustomer(customer: Omit<Customer, "coupons">) {
    try {
      const response = await this.instance.post(
        `updateCustomer/${customer.id}`,
        {
          firstName: customer.firstName,
          lastName: customer.lastName,
          email: customer.email,
          password: customer.password,
        }
      );
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async deleteCustomer(customer: Pick<Required<Customer>, "id">) {
    try {
      const response = await this.instance.delete(
        `deleteCustomer/${customer.id}`
      );
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async getCustomer(customer: Pick<Required<Customer>, "id">): Promise<void> {
    try {
      const customerData = (
        await this.instance.get<Customer>(`getCustomer/${customer.id}`)
      ).data;
      console.log(customerData);
    } catch (err) {
      console.error(err);
    }
  }

  async getAllCustomers(): Promise<Customer[]> {
    try {
      const customersData = (
        await this.instance.get<Customer[]>("getAllCustomers")
      ).data;
      return customersData;
    } catch (err) {
      throw err;
    }
  }
}

export function getCompanies() {
  const controller = new AdminController();
  return controller
    .getAllCompanies()
    .then((result) => result)
    .catch((err) => console.log(err));
}

export function getCustomers() {
  const controller = new AdminController();
  return controller
    .getAllCustomers()
    .then((result) => result)
    .catch((err) => console.log(err));
}

export function addCompany(company: Company) {
  const controller = new AdminController();
  return controller
    .addCompany(company)
    .then((result) => result)
    .catch((err) => {
      throw err;
    });
}
