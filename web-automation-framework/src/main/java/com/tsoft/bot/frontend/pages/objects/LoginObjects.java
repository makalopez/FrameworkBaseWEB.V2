package com.tsoft.bot.frontend.pages.objects;

import org.openqa.selenium.By;

public class LoginObjects {

    public By BtnCancelPromotions = By.id("onesignal-slidedown-cancel-button");
    public By TextModalPromotions = By.className("slidedown-body-message");

    public By BtnLogInUser = By.className("Header__user__login");
    public By LinkTextLogIn = By.linkText("Iniciar sesión / Regístrate");
    public By BtnLogInPlazaProd=By.id("loginWithUserAndPasswordBtn");
    public By InputEmail=By.id("inputEmail");
    public By InputPassword=By.id("inputPassword");
    public By BtnModalLogIn=By.id("classicLoginBtn");
    public By IconPerfUser=By.xpath("//*[@id=\"header-root\"]/header/div[1]/div/div[9]");
    public By BtnCloseBanner = By.xpath("/html/body/div[3]/div[6]/span");
    public By BannerModal = By.className("BannerModalPrecyber");
    public static final String TextLogOut = "Cerrar sesión";
    public By ValidateTextLogOut=By.xpath("//*[@id=\"header-root\"]/header/div[1]/div/div[9]/ul/div/li[5]/a");

}
