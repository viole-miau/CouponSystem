import Coupon from "./Coupon";

type CustomerConstractorArguments = {
  id?: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
};

class Customer {
  public readonly id?: number;
  public firstName: string;
  public lastName?: string;
  public email: string;
  private _password: string;
  public coupons?: Coupon[];

  constructor(args: CustomerConstractorArguments) {
    this.firstName = args.firstName;
    this.lastName = args.lastName;
    this.email = args.email;
    this._password = args.password;
    this.id = args.id;
  }

  get password() {
    return this._password
      .split("")
      .map((char) => "*")
      .join("");
  }

  get fullName(): string {
    return `${this.firstName} ${this.lastName}`.trim();
  }
}

export default Customer;
