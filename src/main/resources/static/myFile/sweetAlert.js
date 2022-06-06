function checkAllFieldFilled() {
    return new Promise(function(resolve, reject) {
        var formData = $("#formSubmit").serializeArray();
        $.each(formData, function(i, v) {
            if (v.value == "") {
                reject();
            }
        });
        resolve();
    })
}

function checkEmail() {
    return new Promise(function (resolve, reject) {
        var email = $("#email").val();
        var checkEmail = typeof email.checkValidity === 'function' ? email.checkValidity() : /\S+@\S+\.\S+/.test(email);
        if (!checkEmail) {
            reject();
        }
        resolve();
    })
}

function checkPassword() {
    return new Promise(function (resolve, reject) {
        var password = $("#password").val();
        var repeatPassword = $("#repeatPassword").val();
        if (password.length < 6) {
            reject(1);
        }
        else if (password != repeatPassword) {
            reject(1);
        }
        resolve();
    });
}

function showCheckAllFieldFillAlert() {
    Swal.fire({
        title: 'You must enter all the fields',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#ddb822',
        cancelButtonText: 'Ok'
    })
}

function showCheckEmailAlert() {
    Swal.fire({
        title: 'your email is not match format!',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#dd2222',
        cancelButtonText: 'Ok'
    });
}

function showPasswordLengthError() {
    Swal.fire({
        title: 'Your password must be have at least 6 characters',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#ddb822',
        cancelButtonText: 'Ok'
    });
}

function showPasswordNotMatchError() {
    Swal.fire({
        title: 'your password is not match format!',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#ddb822',
        cancelButtonText: 'Ok'
    });
}

function getFormData() {
    var data = {};
    var formData = $("#formSubmit").serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    })
    return data;
}


function display(id) {
    var myClass = document.getElementById(id);
    if (myClass.classList.contains("display_active")) {
        myClass.classList.remove("display_active");
    } else {
        myClass.classList.add("display_active");
    }
}

function heartOnClick(id) {
    var heartIcon = document.getElementById(id);
    if (heartIcon.classList.contains("active")) {
        $("#"+id).css('background', '');
        heartIcon.classList.remove("active");
    } else {
        $("#"+id).css('background', '#faa7a7');
        heartIcon.classList.add("active");
    }
}

function socialLogin() {
    Swal.fire({
        title: 'Sorry! Social Login is not active',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#ddb822',
        cancelButtonText: 'Ok'
    })
}

function checkLogin() {
    Swal.fire({
        title: 'You have to login to buy',
        text: 'Login right now',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonColor: '#28a745e0',
        cancelButtonColor: '#dd2222',
        confirmButtonText: 'Right Now',
        cancelButtonText: 'Not Now'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "/login"
        }
    })
}

function alertUsernameExist() {
    Swal.fire({
        title: 'Username is used. Please use other username!',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#ddb822',
        cancelButtonText: 'Ok'
    })
}

function alertEmailExist() {
    Swal.fire({
        title: 'Email is used. Please use other email!',
        icon: 'warning',
        showCancelButton: true,
        showConfirmButton: false,
        cancelButtonColor: '#ddb822',
        cancelButtonText: 'Ok'
    })
}

function alertRegisterSuccessfully(username, password) {
    var textInfo = "username: " + username + "\n" + "password: " + password;
    Swal.fire({
        title: 'Register Successfully!',
        text: '' + textInfo,
        icon: 'success',
        confirmButtonColor: '#28a745e0',
        confirmButtonText: 'Ok'
    })
}

function removeAutoInput() {
    jQuery('input').each( function() {
        // Add your read only attribute and remove it onClick/focus
        jQuery(this).attr('readonly', 'true').attr('onClick', "this.removeAttribute('readonly');");

        // Reintroduce the readonly attribute on mouseleave
        jQuery(this).on('mouseleave', function() {
            jQuery(this).attr('readonly', 'true')
        });
    });
}

function logout() {
    Swal.fire({
        title: 'Logout!',
        text: "Do you want to logout!",
        icon: 'warning',
        showCancelButton: 'yes',
        cancelButtonColor: '#dd2222',
        confirmButtonColor: '#28a745e0',
        confirmButtonText: "Yes",
        cancelButtonText: "No"
    }).then(function(result) {
        if (result.isConfirmed) {
            alert("logout!");
        } else {
            alert("Cancel!");
        }
    })
}

function showApiError() {
    Swal.fire({
        title: 'Error System',
        text: "We are fixing it right now",
        icon: 'warning',
        confirmButtonColor: '#2F8B85',
        confirmButtonText: "Yes",
    })
}


