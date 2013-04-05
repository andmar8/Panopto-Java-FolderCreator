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
package uk.ac.ncl.panopto.panoptofoldercreator;

import uk.ac.ncl.panopto.folder.FolderCreatorTool;

public class PanoptoFolderCreator
{
    /**
     * For some strange reason, a created folder takes a while to register
     * so you may not be able to see it in the API for a short while???
     */
    public static void main(String[] args)
    {
        //server - user - password - foldername
        if(args.length==4)
        {
            new FolderCreatorTool(args[0], args[1], args[2]).createFolder(args[3]);
            return;
        }
        System.out.println("Usage: java -jar PanoptoFolderCreator <Server> <Username> <Password> <FolderName>"
                + "\nE.g.:"
                + "\n\n\tjava -jar PanoptoFolderCreator panopto.ncl.ac.uk admin password Q1213-MAS1342");
    }
}
