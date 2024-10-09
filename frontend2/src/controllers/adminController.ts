import BaseController from "./BaseController";
import Company from "../models/Company";
import Customer from "../models/Customer";

/*export function addCompany(name: string, email: string, password: string) {
  baseController
    .post("admin/addCompany", { name, email, password })
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function updateCompany(
  id: number,
  name: string,
  email: string,
  password: string
) {
  baseController
    .post("admin/updateCompany/${id}", { id, name, email, password })
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function deleteCompany() {
  baseController
    .delete("admin/deleteCompany/${id}")
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function getCompany() {
  baseController
    .get("admin/getCompany/${id}")
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function getAllCompanies() {
  baseController
    .get("admin/getAllCompanies")
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

 export function addCustomer(
  firstName: string,
  lastName: string,
  email: string,
  password: string
) {
  baseController
    .post("admin/addCustomer", { firstName, lastName, email, password })
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function updateCustomer(
  firstName: string,
  lastName: string,
  email: string,
  password: string
) {
  baseController
    .post("admin/updateCustomer/${id}", {
      firstName,
      lastName,
      email,
      password,
    })
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function deleteCustomer() {
  baseController
    .delete("admin/deleteCustomer/${id}")
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function getCustomer() {
  baseController
    .get<Customer>("admin/getCustomer/${id}")
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
}

export function getAllCustomers() {
  baseController
    .get("admin/getAllCustomers")
    .then((response: any) => console.log(response))
    .catch((error: any) => console.log(error));
} */

export default class AdminController extends BaseController {
  constructor() {
    const baseUrl: string = "admin/";
    super(baseUrl);
  }

  async addCompany(company: Omit<Company, "id">) {
    try {
      const response = await this.instance.post("addCompany", {
        name: company.name,
        email: company.email,
        password: company.password,
      });
      console.log(response);
    } catch (err) {
      console.error(err);
    }
  }

  async updateCompany(company: Company) {
    try {
      const response = await this.instance.put(`updateCompany/${company.id}`, {
        name: company.name,
        email: company.email,
        password: company.password,
      });
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
