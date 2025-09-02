document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("employeeForm");
  const fetchForm = document.getElementById("fetchForm");
  const resultDiv = document.getElementById("employeeResult");

  // Add employee
  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const employee = {
      id: document.getElementById("id").value,
      name: document.getElementById("name").value,
      department: document.getElementById("department").value,
      role: document.getElementById("role").value
    };

    fetch("/employees", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(employee)
    })
    .then(response => response.text()) // accept text or JSON
    .then(data => {
      if (data.startsWith("{")) { // check if JSON (employee object)
        const emp = JSON.parse(data);
        alert("Employee added successfully:\n" +
              "ID: " + emp.id + "\n" +
              "Name: " + emp.name + "\n" +
              "Dept: " + emp.department + "\n" +
              "Role: " + emp.role);
      } else {
        alert("Error: " + data); // duplicate ID or backend message
      }
      form.reset();
    })
    .catch(error => console.error("Error:", error));
  });

  // Fetch employee by ID
  fetchForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const empId = document.getElementById("empId").value;

    fetch("/employees/" + empId)
      .then(response => {
        if (!response.ok) {
          return response.text().then(text => { throw new Error(text); });
        }
        return response.json();
      })
      .then(employee => {
        resultDiv.innerHTML = `
          <p><strong>ID:</strong> ${employee.id}</p>
          <p><strong>Name:</strong> ${employee.name}</p>
          <p><strong>Department:</strong> ${employee.department}</p>
          <p><strong>Role:</strong> ${employee.role}</p>
        `;
      })
      .catch(error => {
        resultDiv.innerHTML = `<p style="color:red;">${error.message}</p>`;
      });
  });
});
