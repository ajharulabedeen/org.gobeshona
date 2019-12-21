/**
 * These General Class build caz 
 * these operations required only object type,
 * loading data not possible by this way,
 * Don't know the exact reason,
 * known by testing, benchmark approach.
 * 
 */
package org.gobeshona.persistence;

import java.util.List;

public interface DAO_Generel_Insert_Update_Delete_SelectAll_I
    {
        public String dao_Generel_Insert(Object objectToInsert);
        public String dao_Generel_Update(Object objectToUpdate);
        public String dao_Generel_Delete(Object objectToDelete);
        public List dao_Generel_SelectAll(String query);
    }
