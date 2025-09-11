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
    $.ajax({
        url: '/getEmpNameUsingPost',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ id: employeeId }),
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

// NEW: Add employee function
function addNewEmployee(employeeData) {
    $.ajax({
        url: '/employees',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(employeeData),
        dataType: 'json',
        success: function(response) {
            $('#addResult').html(`<span style="color:green;">✅ ${response}</span>`);
            // Clear the form
            $('#newName').val('');
            $('#newSalary').val('');
        },
        error: function(xhr, status, error) {
            $('#addResult').html(`<span style="color:red;">❌ Error: ${xhr.responseText || error}</span>`);
        }
    });
}

// Display results
function displayEmployeeDetails(employee, employeeId) {
    $('#employeeId').val(employeeId);
    $('#employeeName').val(employee.name);
    $('#employeeSalary').val(employee.salary.toLocaleString());
}