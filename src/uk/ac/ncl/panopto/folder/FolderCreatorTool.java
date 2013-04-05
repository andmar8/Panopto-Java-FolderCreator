    /*
     * This file is part of Panopto-Java-FolderCreator.
     * 
     * Panopto-Java-FolderCreator is free software: you can redistribute it and/or modify
     * it under the terms of the GNU General Public License as published by
     * the Free Software Foundation, either version 3 of the License, or
     * (at your option) any later version.
     * 
     * Panopto-Java-FolderCreator is distributed in the hope that it will be useful,
     * but WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     * GNU General Public License for more details.
     * 
     * You should have received a copy of the GNU General Public License
     * along with Panopto-Java-FolderCreator.  If not, see <http://www.gnu.org/licenses/>.
     * 
     * Copyright: Andrew Martin, Newcastle University
     * 
     */
package uk.ac.ncl.panopto.folder;

import com.panopto.session.SessionManagementStub;
import com.panopto.session.SessionManagementStub.AddFolder;
import com.panopto.session.SessionManagementStub.AuthenticationInfo;
import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

public class FolderCreatorTool
{
    private AuthenticationInfo auth;
    private SessionManagementStub stub;

    public FolderCreatorTool(String server, String user, String password)
    {
        this.auth = new AuthenticationInfo();
        this.auth.setUserKey(user);
        this.auth.setPassword(password);
        try
        {
            stub = new SessionManagementStub("https://"+server+"/Panopto/PublicAPI/4.2/SessionManagement.svc?wsdl");
        }
        catch(org.apache.axis2.AxisFault af)
        {
            System.out.println(af.getMessage());
        }
    }

    public boolean createFolder(String name)
    {
        AddFolder af = new AddFolder();
        af.setAuth(this.auth);
        af.setIsPublic(false);
        af.setName(name);
        af.setParentFolder(null);
        try
        {
            System.out.print("\nAttempting to create folder "+name+"...");
            this.stub.addFolder(af);
        }
        catch(AxisFault axisf)
        {
            System.out.println("error! "+axisf.getMessage());
            return false;
        }
        catch(RemoteException re)
        {
            System.out.println("error! "+re.getMessage());
            return false;
        }
        System.out.println("success (PLEASE NOTE: The folder may take a short while before it is viewable in Panopto)");
        return true;
    }
}
