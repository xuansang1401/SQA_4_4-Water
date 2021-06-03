<%-- 
    Document   : Email
    Created on : Apr 22, 2021, 12:10:01 PM
    Author     : Nal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap Elegant Contact Form</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Patua+One">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css">
<style>
body {
    color: #333;
    background: #fafafa;
    font-family: "Patua One", sans-serif;
}
.contact-form {
    padding: 50px;
    margin: 30px 0;
}
.contact-form h1 {
    color: #19bc9d;
    font-weight: bold;
    margin: 0 0 15px;
}
.contact-form .form-control, .contact-form .btn {
    min-height: 38px;
    border-radius: 2px;
}
.contact-form .form-control:focus {
    border-color: #19bc9d;
}
.contact-form .btn-primary, .contact-form .btn-primary:active {
    color: #fff;
    min-width: 150px;
    font-size: 16px;
    background: #19bc9d !important;
    border: none;
}
.contact-form .btn-primary:hover {
    background: #15a487 !important; 
}
.contact-form .btn i {
    margin-right: 5px;
}
.contact-form label {
    opacity: 0.7;
}
.contact-form textarea {
    resize: vertical;
}
.hint-text {
    font-size: 15px;
    padding-bottom: 20px;
    opacity: 0.6;
}
</style>
</head>
<body>
<div class="container-lg">
    <div class="container">
            <header>
                <a href="#"><img src="img/logo.png" alt=""></a>
            </header>

            <nav>
                <div class="menu">
                    <ul>
                        <li><a href="index.html">TRANG CHỦ</a></li>
                        <li><a href="gioithieu.html">GIỚI THIỆU</a></li>
                        <li><a href="banggia.html">GIÁ NƯỚC</a></li>
                        <li><a href="home">QUẢN LÝ</a></li>
                    </ul>
                </div>
            </nav>

            <div id="slide">
                <a href=""><img src="img/slide.jpg" alt=""></a>
            </div>
        </div>
    <div class="row">
        <div class="col-md-10 mx-auto">
            <div class="contact-form">
                <h1>Contact Us</h1>
                <p class="hint-text">We'd love to hear from you, please drop us a line if you've any query or question.</p>       
                <form >
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label for="inputName">Name</label>
                                <input value="${edit.getName()}" type="text" class="form-control" id="inputName" required>
                            </div>
                        </div>                
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label for="inputEmail">Email</label>
                                <input value="${edit.getEmail()}" type="email" class="form-control" id="inputEmail" required>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label for="inputPhone">Phone</label>
                                <input value="${edit.getPhone()}" type="text" class="form-control" id="inputPhone" required>
                            </div>
                        </div>
                    </div>            
<!--                    <div class="form-group">
                        <label for="inputSubject">Subject</label>
                        <input type="text" class="form-control" id="inputSubject" required>
                    </div>-->
                    <div class="form-group">
                        <label for="inputMessage">Message</label>
                        <textarea class="form-control" type="text" id="inputMessage" rows="5" required></textarea>
                    </div>
                    <a href="#deleteEmployeeModal" id="btn_send" class="btn btn-primary" data-toggle="modal"><i class="fa fa-paper-plane"></i> Send</a>
                </form>
            </div>
        </div>
    </div>
</div>
        <div id="deleteEmployeeModal" class="modal fade" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="delete" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Notification</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div id="textSub" class="modal-body">					
                            <p>You send email success!</p>
                            
                        </div>
                        <div class="modal-footer">
                            <input type="submit" id="btn_send_email" class="btn btn-danger" value="OK">
                        </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>
