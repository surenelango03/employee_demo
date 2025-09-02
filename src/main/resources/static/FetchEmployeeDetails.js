// FetchEmployeeDetails.js

function fetchEmployeeDetails(employeeId) {
    // Use GET method to fetch employee details
    fetch(`/getEmpNameUsingGet?id=${employeeId}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Employee not found');
        }
        return response.json();
    })
    .then(data => {
        displayEmployeeDetails(data);
    })
    .catch(error => {
        document.getElementById("resultText").innerHTML = 
            `<span style="color:red;">Error: ${error.message}</span>`;
    });
}

function displayEmployeeDetails(employee) {
    document.getElementById("resultText").innerHTML = 
        `<strong>Employee ID:</strong> ${getEmployeeIdFromUrl()}<br>
         <strong>Name:</strong> ${employee.name}<br>
         <strong>Salary:</strong> $${employee.salary.toLocaleString()}`;
}

function getEmployeeIdFromUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('id');
}