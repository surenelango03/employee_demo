function fetchEmployeeDetails() {
    let empId = document.getElementById("empId").value;
    let resultsDiv = document.getElementById("results");
    resultsDiv.innerHTML = "Fetching employee details...<br>";

    // GET request
    fetch(`/getEmpNameUsingGet?empId=${empId}`)
        .then(response => response.text())
        .then(data => {
            resultsDiv.innerHTML += "<b>GET Response:</b> " + data + "<br>";
        })
        .catch(error => console.error("Error in GET:", error));

    // POST request
    fetch("/getEmpNameUsingPost", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ empId: empId })
    })
    .then(response => response.text())
    .then(data => {
        resultsDiv.innerHTML += "<b>POST Response:</b> " + data + "<br>";
    })
    .catch(error => console.error("Error in POST:", error));
}
