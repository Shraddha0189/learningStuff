const electron = require('electron');
const url = require('url');
const path = require('path');

const {app, BrowserWindow, Menu, ipcMain} = electron;




//create twi windows.. one for listing of all th eitems and other for adding items to the window
//first window
let mainWindow;

//Listen for the app to be ready
//so once the app is ready it is going to run a function
app.on('ready',function(){
    //Create new window
    mainWindow = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true
          }
    });

    //Load a html file into this window
    mainWindow.loadURL(url.format({
        pathname: path.join(__dirname, 'mainWindow.html'),
        protocol: 'file:',
        slashes: true
    }));   //Basically this is what is getting passed to the URL finally=> file://dirname/mainWindow.html


    //close all the child windows when user closes the mainWindow
    mainWindow.on('closed',function(){
        app.quit();
    });

    //Build menu from template
    const mainMenu = Menu.buildFromTemplate(menuTemplate);

    //Insert the menu 
    Menu.setApplicationMenu(mainMenu);
     
});





//handle create add window
/*This function will create a smaller window for user to put item name*/
function createAddWindow()
{
    //Create new window
    addWindow = new BrowserWindow({
        width: 300,
        height: 200,
        title: 'Add items to shopping list',
        webPreferences: {
            nodeIntegration: true
          }
    });

    //Load a html file into this window
    addWindow.loadURL(url.format({
        pathname: path.join(__dirname, 'addWindow.html'),
        protocol: 'file:',
        slashes: true
    }));   //Basically this is what is getting passed to the URL finally=> file://dirname/mainWindow.html

    //Handle the garbage collection when add window is closed 
    //release the memory of addWindow by setting it to null
    addWindow.on('closed',function(){
        addWindow = null;
    });
}

//Create a menu template
//create array of menu objects

const menuTemplate = [
    {
        label:'File',
        submenu:[
            {
                label: 'Add Item',
                click(){
                    createAddWindow();
                }
            },
            {
                label: 'Clear Items',
                click(){
                    mainWindow.webContents.send('item:clear');
                }
            },
            {
                label: 'Quit',
                accelerator: process.platform == 'darwin' ? 'Command+Q' : 'Ctrl+Q' ,//to add shortcut keyss for this quit button
                click(){
                    app.quit(); 
                }
            }
        ]
    }

];

/*the "File" menu is seen as "Electron" menu in MAC.. But in order to handle this you need to add empty object {} to the menu template.
  But this will create an extra space in windows..so we need to handle this acc to underlying platform
*/
if(process.platform == 'darwin')
{
    menuTemplate.unshift({}); //unshift api adds empty object at the start of the array
}

/* Add developer tool options if not in production */
if(process.env.NODE_ENV != 'production')
{
    menuTemplate.push({
        label: 'Developer Tools',
        submenu : [
            {
                label: 'Toggle Dev Tools',
                accelerator: process.platform == 'darwin' ? 'Command+I' : 'Ctrl+I' ,//to add shortcut keys for this quit button
                click(item,focusedWindow){
                    focusedWindow.toggleDevTools();
                    //focusedWindow.openDevTools({mode:'detach'});
                }
            },
            {
                role: 'reload',
            }
        ]

    });
}


//catch the ipc renderer event using ipc main
ipcMain.on("item:add", function(event,item)
{
    //send the data from appWindow 
    mainWindow.webContents.send("item:add",item);
    addWindow.close();
});