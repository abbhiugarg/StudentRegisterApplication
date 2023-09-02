document.addEventListener("DOMContentLoaded", function () {
  // For print date-time at header
  function updateDateTime() {
    const now = new Date();
    const dateTimeString = now.toLocaleString();
    document.getElementById("date-time").innerHTML = dateTimeString;
  }
  updateDateTime();
  setInterval(updateDateTime, 1000);

  // For checking form input field data(validation)
  const form = document.getElementById("student-form");
  const nameInput = document.getElementById("name");
  const emailInput = document.getElementById("email");
  const mobileInput = document.getElementById("mobile");

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    if (!validateName(nameInput.value)) {
      alert("Name should only contain letters and spaces.");
      return;
    }

    if (!validateEmail(emailInput.value)) {
      alert("Invalid email format.");
      return;
    }

    if (!validateMobile(mobileInput.value)) {
      alert("Invalid mobile number format.");
      return;
    }

    const studentId = $("#student-id").val();

    if (studentId) {
      // Updating an existing student
      const updatedStudent = {
        id: studentId,
        name: nameInput.value,
        email: emailInput.value,
        phoneNo: mobileInput.value,
      };

      $.ajax({
        url: "http://localhost:8080/students",
        type: "PUT",
        data: JSON.stringify(updatedStudent),
        contentType: "application/json",
        success: function () {
          alert("Student data updated successfully!");
          nameInput.value = "";
          emailInput.value = "";
          mobileInput.value = "";

          window.location.href =
            "http://127.0.0.1:5500/UIStudentAppProject/ViewStudent/viewstudent.html";
        },
        error: function () {
          console.error("Error updating student data.");
        },
      });
    } else {
      const student = {
        name: nameInput.value,
        email: emailInput.value,
        phoneNo: mobileInput.value,
      };

      fetch("http://localhost:8080/students", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(student),
      })
        .then((response) => response.json())
        .then((data) => {
          console.log("Student added:", data);
          alert(
            `Thank you ${data.name} for registering!\nYour University Id is ${data.id}`
          );

          nameInput.value = "";
          emailInput.value = "";
          mobileInput.value = "";
          window.location.href =
            "http://127.0.0.1:5500/UIStudentAppProject/ViewStudent/viewstudent.html";
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    }
  });

  // Other functions (validateName, validateEmail, validateMobile) here
  function validateName(name) {
    return /^[A-Za-z\s]+$/.test(name) && name.length <= 50;
  }

  function validateEmail(email) {
    return /^[a-zA-Z0-9_.]+@[a-zA-Z]+\.[a-zA-Z]{2,}$/.test(email);
  }

  function validateMobile(mobile) {
    return /^[6-9]{1}[0-9]{9}$/.test(mobile);
  }
});

$(document).ready(function () {
  // Get all students from the database
  $.get("http://localhost:8080/students", function (data) {
    // Loop through the students and add them to the table
    $(data).each(function (index, student) {
      var row = $("<tr>");
      var idCell = $("<td>").text(student.id);
      var nameCell = $("<td>").text(student.name);
      var emailCell = $("<td>").text(student.email);
      var phoneCell = $("<td>").text(student.phoneNo);
      var actionCell = $("<td>");

      var editButton = $("<button>").text("Edit").addClass("edit");
      var deleteButton = $("<button>").text("Delete").addClass("delete");

      var actionButtonsContainer = $("<div>").addClass("action-buttons");
      actionButtonsContainer.append(editButton);
      actionButtonsContainer.append(deleteButton);

      actionCell.append(actionButtonsContainer);

      editButton.click(function () {
        window.location.href =
          "http://127.0.0.1:5500/UIStudentAppProject/CreateStudent/createstudent.html?id=" +
          student.id;
        // console.log("Edit button clicked for student:", student);
      });

      deleteButton.click(function () {
        if (confirm("Are you sure you want to delete this student?")) {
          $.ajax({
            url: "http://localhost:8080/students/" + student.id,
            type: "DELETE",
            success: function () {
              console.log("Student deleted:", student);
              row.remove();
            },
            error: function () {
              console.error("Error deleting student:", student);
            },
          });
        }
      });

      row.append(idCell);
      row.append(nameCell);
      row.append(emailCell);
      row.append(phoneCell);
      row.append(actionCell);

      $("#student-tbody").append(row);
    });
  });
});

const urlParams = new URLSearchParams(window.location.search);
const studentId = urlParams.get("id");

if (studentId != null) {
  $.get("http://localhost:8080/students/" + studentId, function (data) {
    $("#student-id").val(data.id);
    $("#name").val(data.name);
    $("#email").val(data.email);
    $("#mobile").val(data.phoneNo);
  });
}
