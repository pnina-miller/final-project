export class User {
    userId: number
    email: String
    password: String
    identityNum: number
    firstName: String
    lastName: String
    birthDate: Date
    gender: String
    street: String
    houseNum: number
    neighborhood: String
    city: String
    country: String
    enterance: String
    aptNum: number
    status: String
    creditNum: number
    csv: number
    valid: Date
    postalCode: number
    aptArea: number
    rebuildNeighborhood: String
    childrenAmount: number
    ipAddress: String
}
export class Result {
     data:User[]
     status:number
}