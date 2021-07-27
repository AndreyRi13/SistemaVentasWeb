<%-- 
    Document   : registrarComprador
    Created on : 16/07/2021, 5:34:02 p. m.
    Author     : Andrey R
--%>


<%@include file="./header.jsp" %>


<div class="container">
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
                        </div><!-- comment -->

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
</div>



<%@include file="./footer.jsp" %>