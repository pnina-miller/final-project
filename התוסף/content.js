
console.log("content.js")
// קיצור דרך:cntrl+Q
function KeyPress(e) {
    var evtobj = window.event ? window.event : e
    // if (evtobj.keyCode == 81 && evtobj.ctrlKey)
    EasyForm();
}

// document.onkeydown = KeyPress;
// document.onkeypress = KeyPress;
document.onkeyup = KeyPress;

a = document.querySelectorAll("input")
var searchText = ['Phone', 'Fname', 'first_name', 'author', 'firstname', 'fname', 'firstName', 'FirstName'
    , 'last_name', 'Lname', 'lastname', 'lname', 'lastName', 'LastName', 'user_password', 'email', 'Email', 'address', 'Address',
    'user_login', 'form-field-email', 'password', 'login__user_password',
    'identity_number', 'Inidnum', 'IDNum', 'street_name', 'neighborhood_name', 'building_number'
    , 'postal_code', 'city', 'country', 'birthday', 'birth_date', 'Birthday', 'profession', 'Phone', 'AphoneNumber', 'acountnumber'];
//איך לקצר מערך זה?
var fill = ['0543241232', 'Shoshana', 'Shoshana', 'Shoshana', 'Shoshana', 'Shoshana', 'Shoshana', 'Shoshana', 'Levi'
    , 'Levi', 'Levi', 'Levi', 'Levi', 'Levi', 'Levi', '7547884@gmail.com', '7547884@gmail.com', '7547884@gmail.com'
    , 'Harohe', '7547884@gmail.com', '12345', '123456',
    '315298838', '315298838', '315298838', '315298838', 'Harohe', 'ramot', '19', '5676', 'Jerusalem', 'Israel', '2020-06-07', '2020-06-07', '2020-06-07', 'teacher', '0543241232', '0543241232', '123455678'];
// EasyForm();
async function EasyForm() {
    fetch("http://localhost:8080/test/user/GetAllUsers")
        .then(data => data.json())
        .then(users => {
            var user = users.data[0]
            searchText.forEach(element => {
                if (document.getElementById(element) != null)
                    document.getElementById(element).value = fill[searchText.indexOf(element)];
                for (let item of a) {
                    if (item.id.indexOf(element) > -1)
                        item.value = fill[searchText.indexOf(element)];
                }
            });
        })
}
var searchText2 = {
    Emai1: ['email', 'Email', 'user_login', 'form-field-email'],
    password2: ['user_password', 'password', 'login__user_password'],
    IdentityNum3: ['identity_number', 'IDNum'],
    FirstName4: ['first_name', 'author', 'firstname', 'fname', 'firstName', 'FirstName'],
    LastName5: ['last_name', 'lastname', 'lname', 'lastName', 'LastName'],
    BirthDate6: ['birth_date'],
    Gender7: [],
    Street8: ['address', 'Address', 'street_name'],
    HouseNum9: ['building_number'],
    Enterance10: [],
    Neighborhood11: ['neighborhood_name'],
    PostalCode12: ['postal_code'],
    City13: ['city'],
    Country14: ['country'],
    AptNum15: [],
    Status16: [],
    CreditNum17: [],
    Csv18: [],
    Valid19: [],
    AptArea20: [],
    RebuildNeighborhood21: []
}

var fill2 = []
// var res = await $.get("https://ipapi.co/8.8.8.8/json/")
// console.log("get", res)
// var ipAddress = res.responseJSON.ip;


// fill2['Email1: user.Email
// fill2['password2: user.password
// fill2['IdentityNum3: user.IdentityNum
// fill2['FirstName4: user.FirstName
// fill2['LastName5: user.LastName
// fill2['BirthDate6: user.BirthDate
// fill2['Gender7: user.Gender
// fill2['Street8: user.Street
// fill2['HouseNum9: user.HouseNum
// fill2['Enterance10: user.Enterance
// fill2['Neighborhood11: user.Neighborhood
// fill2['PostalCode12: user.PostalCode
// fill2['City13: user.City
// fill2['Country14: user.Country
// fill2['AptNum15: user.AptNum
// fill2['Status16: user.Status
// fill2['CreditNum17: user.CreditNum
// fill2['Csv18: user.Csv
// fill2['Valid19: user.Valid
// fill2['AptArea20: user.AptArea
// fill2['RebuildNeighborhood21: user.RebuildNeighborhood
// EasyForm2()
// })




function EasyForm2() {
    searchText2.forEach(elementArr => {
        elementArr.forEach((element) => {
            if (document.getElementById(element) != null)
                document.getElementById(element).value = fill2[element];
            for (let item of a) {
                if (item.id.indexOf(element) > -1)
                    item.value = fill2[searchText.indexOf(element)];
            }
        })

    });
} 