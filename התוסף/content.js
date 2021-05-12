

// קיצור דרך:cntrl+Q
function KeyPress(e) {
    var evtobj = window.event ? window.event : e
    if (e.ctrlKey && e.charCode == 17)
        EasyForm();
}
document.onkeypress = KeyPress;
async function EasyForm() {
    const a = document.querySelectorAll("input")
    const response = await $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/test/values/',
        mode: 'no-cors'
    })
    console.log('response', response);
    let info = []
    response.data.forEach(item => info.push([item[2].optionName, item[1]]))
    console.log(info);
    info.forEach(element => {
        if (document.getElementById(element[0]) != null)
            document.getElementById(element[0]).value = element[1];
        for (let item of a)
            if (item.id.indexOf(element) > -1)
                item.value = element[1];

    });

}

