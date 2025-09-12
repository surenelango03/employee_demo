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

// POST request (JSON body)
function fetchUsingPost(employeeId) {
    const dto = { id: employeeId };

    $.ajax({
        url: '/getEmpNameUsingPost',
        method: 'POST',
        contentType: 'application/json', // important for JSON
        data: JSON.stringify(dto),       // convert JS object to JSON string
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
    $('#employeeSalary').val(employee.salary);
}
