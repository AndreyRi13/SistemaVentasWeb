<%-- 
    Document   : registrarComprador
    Created on : 16/07/2021, 5:34:02 p. m.
    Author     : Andrey R
--%>


<%@include file="./header.jsp" %>


<!--<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">

                <form class="form-horizontal" action="compradorcontroller?menu=registroComprador" method="POST">
                    <fieldset>
<br>
                        <legend class="text-center header">Formulario de registro</legend>
                        <div class="row">
                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Cedula</label>
                                <input id="fname" name="txtCedula" type="text" placeholder="Digite la Cedula" class="form-control">
                            </div>
                        </div>


                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Nombres</label>
                                <input id="fname" name="txtNombres" type="text" placeholder="Digite los Nombres" class="form-control">
                            </div>
                        </div>

                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Apellidos</label>
                                <input id="fname" name="txtApellidos" type="text" placeholder="Digite los Apellidos" class="form-control">
                            </div>
                        </div>

                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Username</label>
                                <input id="fname" name="txtUsername" type="text" placeholder="Digite el Username" class="form-control">
                            </div>
                        </div> comment 

                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Password</label>
                                <input id="fname" name="txtPassword" type="text" placeholder="Digite la Password" class="form-control">
                            </div>
                        </div>

                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Direccion</label>
                                <input id="fname" name="txtDireccion" type="text" placeholder="Digite la Direccion" class="form-control">
                            </div>
                        </div>

                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Numero de Celular</label>
                                <input id="fname" name="txtNumeroCelular" type="text" placeholder="Digite el Numero de Celular" class="form-control">
                            </div>
                        </div>



                        <div class="form-group col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>                                     
                            <div class="col-lg-6 col-sm-6 col-xl-6 col-6 col-md-6">
                                <label>Correo Electronico</label>
                                <input id="fname" name="txtCorreoElectronico" type="text" placeholder="Digite el Correo Electronico" class="form-control">
                            </div>
                        </div>
                        <br><br><br><br><br><br>
</div>
                        <div class="form-group col-lg-12 col-sm-12 col-xl-12 col-12 col-md-12">
                            <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-primary btn-lg">Registrarme</button>
                            </div>
                        </div>
                        <br><br><br>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>-->

<div class="container register">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="../images/logo_white.png" alt=""/>
            <h3 style="color: #3a4468;">Bienvenido</h3>
            <p style="color: #3a4468;">Si ya tienes con una cuenta, inicia sesion y disfruta de las promociones!</p>
            <input  class="border" style="border-color: #3a4468;" type="submit" name="" value="Login"/><br/>
        </div>
        <div class="col-md-9 register-right">
<!--            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Hirer</a>
                </li>
            </ul>-->
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Registro</h3>
                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="First Name *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Last Name *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control"  placeholder="Confirm Password *" value="" />
                            </div>
                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline"> 
                                        <input type="radio" name="gender" value="male" checked>
                                        <span> Male </span> 
                                    </label>
                                    <label class="radio inline"> 
                                        <input type="radio" name="gender" value="female">
                                        <span>Female </span> 
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Your Email *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control" placeholder="Your Phone *" value="" />
                            </div>
                            <div class="form-group">
                                <select class="form-control">
                                    <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                    <option>What is your Birthdate?</option>
                                    <option>What is Your old Phone Number</option>
                                    <option>What is your Pet Name?</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Enter Your Answer *" value="" />
                            </div>
                            <input type="submit" class="btnRegister"  value="Register"/>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <h3  class="register-heading">Apply as a Hirer</h3>
                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="First Name *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Last Name *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Email *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="text" maxlength="10" minlength="10" class="form-control" placeholder="Phone *" value="" />
                            </div>


                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password *" value="" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirm Password *" value="" />
                            </div>
                            <div class="form-group">
                                <select class="form-control">
                                    <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                    <option>What is your Birthdate?</option>
                                    <option>What is Your old Phone Number</option>
                                    <option>What is your Pet Name?</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="`Answer *" value="" />
                            </div>
                            <input type="submit" class="btnRegister"  value="Register"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="./footer.jsp" %>