package com.sistecredito.bot.Main;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;



public class Execute {
    public static void main(String[] args) throws InterruptedException {

        /*Windows*/
//        System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver-win64\\chromedriver.exe");

        /*Linux*/
        System.setProperty("webdriver.chrome.driver", "/opt/robotmesasdbapp/sistecredito/chromedriver");

        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-plugins");
//        options.addArguments("--start-maximized");
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.manage().deleteAllCookies();

        try{
            /*Abre Navegador*/
            driver.get("https://csm3.serviceaide.com/#login");
            Thread.sleep(5000);

            /*Inicio de Sesion*/
            driver.findElement(
                            By.id("textfield-1016-inputEl"))
                    .sendKeys("analistadbapp-marco@arus.com.co", Keys.TAB);
            driver.findElement(
                            By.id("textfield-1017-inputEl"))
                    .sendKeys("Arus2021**+Octubre");
            driver.findElement(
                            By.id("button-1021-btnEl"))
                    .click();


            Thread.sleep(20000);

            /*Busqueda del Ticket en Cola*/
            WebElement ticket;
            int ticketCounter = 2;
            String ticketPath;
            String validation;

            do {
                ticketPath = "/html/body/div[3]/div[2]/div[1]/div/div[2]/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div[5]/div/table/tbody/tr["+ ticketCounter +"]/td/div/table/tbody/tr[1]/td[5]/div/div/table/tbody/tr[3]/td[1]";
                ticket = driver.findElement(By.xpath(ticketPath));
                validation = ticket.getText();
                ticketCounter++;

            }while ((!validation.equals("En cola | Asignación")) && (ticketCounter < 25));


            if (validation.equals("En cola | Asignación")){

                System.out.println(validation);
                actions.doubleClick(ticket).perform();
                Thread.sleep(15000);

                /*Registro de trabajo*/
                driver.findElement(
                                By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[2]/em/button"))
                        .click();
                Thread.sleep(1000);

                /*Texto*/
                driver.findElement(
                                By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div/div/table/tbody/tr[1]/td[2]/textarea"))
                        .sendKeys("Nombre analista o soporte: \n" +
                                "Grupo de gestión: GTI - Base de datos\n" +
                                "Descarte y/o pruebas: N/A\n" +
                                "Detalles de la solución:");

                /*Actions*/
                driver.findElement(
                                By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div/span[2]/div/em/button"))
                                .click();
                Thread.sleep(2000);

                /*Texto Nuevamente*/
                driver.findElement(
                          By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[1]/div/div/table/tbody/tr[1]/td[2]/textarea"))
                        .click();
                Thread.sleep(2000);

                /*Tomar Propiedad*/
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("// Encontrar el span por su contenido de texto\n" +
                        "var spans = document.querySelectorAll('span'); // Selecciona todos los elementos <span>\n" +
                        "\n" +
                        "spans.forEach(function(spanElement) {\n" +
                        "    if (spanElement.textContent === \"Tomar propiedad\") {\n" +
                        "        // Obtener el ID del elemento\n" +
                        "        var id = spanElement.id;\n" +
                        "        \n" +
                        "        // Mostrar el ID en la consola\n" +
                        "        console.log(\"ID correspondiente:\", id);\n" +
                        "        \n" +
                        "        // Agregar un evento de clic al elemento con el ID obtenido\n" +
                        "        var elementoConId = document.getElementById(id);\n" +
                        "        if (elementoConId) {\n" +
                        "            elementoConId.addEventListener(\"click\", function() {\n" +
                        "                // Tu código a ejecutar cuando se hace clic en el elemento\n" +
                        "                console.log(\"Clic en el elemento con ID:\", id);\n" +
                        "            });\n" +
                        "            \n" +
                        "            // Simular un clic en el elemento\n" +
                        "            elementoConId.click();\n" +
                        "        }\n" +
                        "    }\n" +
                        "});");
                Thread.sleep(5000);
                System.out.println("Propiedad del caso Tomada");

                /*Cerrar Sesión*/
                driver.findElement(
                                By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div/div[1]/em/button"))
                                .click();
                Thread.sleep(1000);

                js.executeScript("// Encontrar el span por su contenido de texto\n" +
                        "var spans = document.querySelectorAll('span'); // Selecciona todos los elementos <span>\n" +
                        "\n" +
                        "spans.forEach(function(spanElement) {\n" +
                        "    if (spanElement.textContent === \"Cerrar sesión\") {\n" +
                        "        // Obtener el ID del elemento\n" +
                        "        var id = spanElement.id;\n" +
                        "        \n" +
                        "        // Mostrar el ID en la consola\n" +
                        "        console.log(\"ID correspondiente:\", id);\n" +
                        "        \n" +
                        "        // Agregar un evento de clic al elemento con el ID obtenido\n" +
                        "        var elementoConId = document.getElementById(id);\n" +
                        "        if (elementoConId) {\n" +
                        "            elementoConId.addEventListener(\"click\", function() {\n" +
                        "                // Tu código a ejecutar cuando se hace clic en el elemento\n" +
                        "                console.log(\"Clic en el elemento con ID:\", id);\n" +
                        "            });\n" +
                        "            \n" +
                        "            // Simular un clic en el elemento\n" +
                        "            elementoConId.click();\n" +
                        "        }\n" +
                        "    }\n" +
                        "});");

                System.out.println("Cerrando Sesión");

                /*Cerrar Navegador*/
                Thread.sleep(4000);
                driver.manage().deleteAllCookies();
                System.out.println("Proceso Exitoso");
                Thread.sleep(2000);
                driver.quit();

            }else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                System.out.println("No hay casos pendientes");

                /*Cerrar Sesión*/
                driver.findElement(
                                By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div/div[1]/em/button"))
                        .click();
                Thread.sleep(1000);

                js.executeScript("// Encontrar el span por su contenido de texto\n" +
                        "var spans = document.querySelectorAll('span'); // Selecciona todos los elementos <span>\n" +
                        "\n" +
                        "spans.forEach(function(spanElement) {\n" +
                        "    if (spanElement.textContent === \"Cerrar sesión\") {\n" +
                        "        // Obtener el ID del elemento\n" +
                        "        var id = spanElement.id;\n" +
                        "        \n" +
                        "        // Mostrar el ID en la consola\n" +
                        "        console.log(\"ID correspondiente:\", id);\n" +
                        "        \n" +
                        "        // Agregar un evento de clic al elemento con el ID obtenido\n" +
                        "        var elementoConId = document.getElementById(id);\n" +
                        "        if (elementoConId) {\n" +
                        "            elementoConId.addEventListener(\"click\", function() {\n" +
                        "                // Tu código a ejecutar cuando se hace clic en el elemento\n" +
                        "                console.log(\"Clic en el elemento con ID:\", id);\n" +
                        "            });\n" +
                        "            \n" +
                        "            // Simular un clic en el elemento\n" +
                        "            elementoConId.click();\n" +
                        "        }\n" +
                        "    }\n" +
                        "});");
                System.out.println("Cerrando Sesión Sin Casos");
                Thread.sleep(3000);
                driver.manage().deleteAllCookies();
                Thread.sleep(2000);
                driver.quit();
            }

        }catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            System.out.println("Error en ejecución");
            System.out.println(e);
            Thread.sleep(2000);

            driver.findElement(
                            By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div/div[1]/em/button"))
                    .click();
            Thread.sleep(1000);

            js.executeScript("// Encontrar el span por su contenido de texto\n" +
                    "var spans = document.querySelectorAll('span'); // Selecciona todos los elementos <span>\n" +
                    "\n" +
                    "spans.forEach(function(spanElement) {\n" +
                    "    if (spanElement.textContent === \"Cerrar sesión\") {\n" +
                    "        // Obtener el ID del elemento\n" +
                    "        var id = spanElement.id;\n" +
                    "        \n" +
                    "        // Mostrar el ID en la consola\n" +
                    "        console.log(\"ID correspondiente:\", id);\n" +
                    "        \n" +
                    "        // Agregar un evento de clic al elemento con el ID obtenido\n" +
                    "        var elementoConId = document.getElementById(id);\n" +
                    "        if (elementoConId) {\n" +
                    "            elementoConId.addEventListener(\"click\", function() {\n" +
                    "                // Tu código a ejecutar cuando se hace clic en el elemento\n" +
                    "                console.log(\"Clic en el elemento con ID:\", id);\n" +
                    "            });\n" +
                    "            \n" +
                    "            // Simular un clic en el elemento\n" +
                    "            elementoConId.click();\n" +
                    "        }\n" +
                    "    }\n" +
                    "});");

            Thread.sleep(3000);
            driver.manage().deleteAllCookies();
            Thread.sleep(2000);
            driver.quit();
        }

    }
}
