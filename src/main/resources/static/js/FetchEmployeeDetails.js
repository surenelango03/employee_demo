// FetchEmployeeDetails.js

// GET request
function fetchEmployeeDetails(employeeId) {
    $.ajax({
        url: `/getEmpNameUsingGet?id=${employeeId}`,
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            displayEmployeeDetails(data, employeeId);
        },
        error: function(xhr, status, error) {
            $('#employeeName').val('Error: Employee not found');
            $('#employeeSalary').val('');
        }
    });
}

// POST request
function fetchUsingPost(employeeId) {
    const formData = { id: employeeId };

    $.ajax({
        url: '/getEmpNameUsingPost',
        method: 'POST',
        data: formData,   // sends as x-www-form-urlencoded
        dataType: 'json',
        success: function(data) {
            displayEmployeeDetails(data, employeeId);
        },
        error: function(xhr, status, error) {
            $('#employeeName').val('Error: Employee not found');
            $('#employeeSalary').val('');
        }
    });
}

// Display results
function displayEmployeeDetails(employee, employeeId) {
    $('#employeeId').val(employeeId);
    $('#employeeName').val(employee.name);
    $('#employeeSalary').val(employee.salary.toLocaleString());
}
