<%-- 
    Document   : registrarComprador
    Created on : 16/07/2021, 5:34:02 p. m.
    Author     : Andrey R
--%>


<%@include file="./header.jsp" %>

<div class="container register">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="../images/logo_white.png" alt=""/>
            <h3 style="color: #3a4468;">Bienvenido</h3>
            <p style="color: #3a4468;">Si ya tienes con una cuenta, inicia sesion y disfruta de las promociones!</p>
            <input  class="border" style="background-color: #3a4468; color: white;"type="submit" name="" value="Login"/><br/>
        </div>
        <div class="col-md-9 register-right">
          
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Registro</h3>
                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input id="fname" name="txtCedula" type="text" placeholder="Cedula" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <input id="fname" name="txtEdad" type="number" placeholder="Fecha de nacimiento" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="fname" name="txtUsername" type="text" placeholder="Username" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="fname" name="txtPassword" type="text" placeholder="Password" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="fname" name="txtPassword" type="text" placeholder="Confirma tu Password" class="form-control">
                            </div>

                            <div class="form-group">
                                <label>Genero:</label>
                                <div class="maxl">

                                    <label class="radio inline"> 
                                        <input type="radio" name="txtGenero" value="masculino" checked>
                                        <span> Masculino </span> 
                                    </label>

                                    <label class="radio inline"> 
                                        <input type="radio" name="txtGenero" value="femenino">
                                        <span>Femenino </span> 
                                    </label>

                                    <label class="radio inline"> 
                                        <input type="radio" name="txtGenero" value="otro">
                                        <span>Otro </span> 
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input id="fname" name="txtNombres" type="text" placeholder="Nombres" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <input id="fname" name="txtApellidos" type="text" placeholder="Apellidos" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <input id="fname" name="txtDireccion" type="text" placeholder="Direccion" class="form-control">
                            </div>
                            <div class="form-group">
                                <input id="fname" name="txtNumeroCelular" type="text" placeholder="Numero de Celular" class="form-control">
                            </div>
                            <div id="file-select" class="form-group">
      
                                <input id="fotoPerfil" value="Foto de Perfil" type="file" name="txtFoto" accept="image/png, .jpeg, .jpg, image/gif">
                             
                            </div>
                            <input style="background-color: #3a4468; color: white;" type="submit" class="btnRegister"  value="Registrarme"/>
                        </div>
                    </div>
                </div>
                <!--                <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
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
                                </div>-->
            </div>
        </div>
    </div>

</div>

<%@include file="./footer.jsp" %>