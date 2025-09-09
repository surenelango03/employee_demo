// FetchEmployeeDetails.js

function fetchEmployeeDetails(employeeId) {
    // Use jQuery AJAX for GET request
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

function displayEmployeeDetails(employee, employeeId) {
    // Use jQuery to set values
    $('#employeeId').val(employeeId);
    $('#employeeName').val(employee.name);
    $('#employeeSalary').val(employee.salary.toLocaleString());
}

// Function to demonstrate jQuery serialize (though not needed for current flow)
function captureFormData() {
    // Example of using serializeArray
    const formData = $('#employeeDetailsForm').serializeArray();
    console.log('Form data:', formData);
    
    // Example of using serialize
    const serializedData = $('#employeeDetailsForm').serialize();
    console.log('Serialized data:', serializedData);
    
    return formData;
}

// Function to demonstrate POST with jQuery (though not needed for current flow)
function submitEmployeeDataUsingPost(formData) {
    // Convert formData array to object
    const dataObject = {};
    $.each(formData, function() {
        dataObject[this.name] = this.value;
    });
    
    // Use jQuery AJAX for POST request
    $.ajax({
        url: '/getEmpNameUsingPost',
        method: 'POST',
        data: dataObject,
        dataType: 'json',
        success: function(response) {
            console.log('POST successful:', response);
        },
        error: function(xhr, status, error) {
            console.error('POST failed:', error);
        }
    });
}

// Optional: Function to handle form submission with POST method
function fetchUsingPost(employeeId) {
    // Create form data object for POST
    const formData = {
        id: employeeId
    };
    
    // Use jQuery AJAX for POST request
    $.ajax({
        url: '/getEmpNameUsingPost',
        method: 'POST',
        data: formData,
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