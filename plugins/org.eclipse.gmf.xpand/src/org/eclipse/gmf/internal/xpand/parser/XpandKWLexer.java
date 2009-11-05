/*
 * Copyright (c) 2006, 2009 Borland Software Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - Xpand language syntax
 *     Artem Tikhomirov (Borland) - LALR grammar
 *                                - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.parser;




public class XpandKWLexer extends XpandKWLexerprs implements XpandParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[128 + 1];

    public int[] getKeywordKinds() { return keywordKind; }

    public int lexer(int curtok, int lasttok)
    {
        int current_kind = getKind(inputChars[curtok]),
            act;

        for (act = tAction(START_STATE, current_kind);
             act > NUM_RULES && act < ACCEPT_ACTION;
             act = tAction(act, current_kind))
        {
            curtok++;
            current_kind = (curtok > lasttok
                                   ? Char_EOF
                                   : getKind(inputChars[curtok]));
        }

        if (act > ERROR_ACTION)
        {
            curtok++;
            act -= ERROR_ACTION;
        }

        return keywordKind[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
    }

    public void setInputChars(char[] inputChars) { this.inputChars = inputChars; }


    final static int tokenKind[] = new int[128];
    static
    {
        tokenKind['$'] = Char_DollarSign;

        tokenKind['a'] = Char_a;
        tokenKind['b'] = Char_b;
        tokenKind['c'] = Char_c;
        tokenKind['d'] = Char_d;
        tokenKind['e'] = Char_e;
        tokenKind['f'] = Char_f;
        tokenKind['g'] = Char_g;
        tokenKind['h'] = Char_h;
        tokenKind['i'] = Char_i;
        tokenKind['j'] = Char_j;
        tokenKind['k'] = Char_k;
        tokenKind['l'] = Char_l;
        tokenKind['m'] = Char_m;
        tokenKind['n'] = Char_n;
        tokenKind['o'] = Char_o;
        tokenKind['p'] = Char_p;
        tokenKind['q'] = Char_q;
        tokenKind['r'] = Char_r;
        tokenKind['s'] = Char_s;
        tokenKind['t'] = Char_t;
        tokenKind['u'] = Char_u;
        tokenKind['v'] = Char_v;
        tokenKind['w'] = Char_w;
        tokenKind['x'] = Char_x;
        tokenKind['y'] = Char_y;
        tokenKind['z'] = Char_z;

        tokenKind['A'] = Char_A;
        tokenKind['B'] = Char_B;
        tokenKind['C'] = Char_C;
        tokenKind['D'] = Char_D;
        tokenKind['E'] = Char_E;
        tokenKind['F'] = Char_F;
        tokenKind['G'] = Char_G;
        tokenKind['H'] = Char_H;
        tokenKind['I'] = Char_I;
        tokenKind['J'] = Char_J;
        tokenKind['K'] = Char_K;
        tokenKind['L'] = Char_L;
        tokenKind['M'] = Char_M;
        tokenKind['N'] = Char_N;
        tokenKind['O'] = Char_O;
        tokenKind['P'] = Char_P;
        tokenKind['Q'] = Char_Q;
        tokenKind['R'] = Char_R;
        tokenKind['S'] = Char_S;
        tokenKind['T'] = Char_T;
        tokenKind['U'] = Char_U;
        tokenKind['V'] = Char_V;
        tokenKind['W'] = Char_W;
        tokenKind['X'] = Char_X;
        tokenKind['Y'] = Char_Y;
        tokenKind['Z'] = Char_Z;
    };

    final int getKind(char c)
    {
        return (c < 128 ? tokenKind[c] : 0);
    }


    public XpandKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= s e l f
        //
		keywordKind[1] = (TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i f
        //
		keywordKind[2] = (TK_if);
	  
	
        //
        // Rule 3:  KeyWord ::= t h e n
        //
		keywordKind[3] = (TK_then);
	  
	
        //
        // Rule 4:  KeyWord ::= e l s e
        //
		keywordKind[4] = (TK_else);
	  
	
        //
        // Rule 5:  KeyWord ::= e n d i f
        //
		keywordKind[5] = (TK_endif);
	  
	
        //
        // Rule 6:  KeyWord ::= a n d
        //
		keywordKind[6] = (TK_and);
	  
	
        //
        // Rule 7:  KeyWord ::= o r
        //
		keywordKind[7] = (TK_or);
	  
	
        //
        // Rule 8:  KeyWord ::= x o r
        //
		keywordKind[8] = (TK_xor);
	  
	
        //
        // Rule 9:  KeyWord ::= n o t
        //
		keywordKind[9] = (TK_not);
	  
	
        //
        // Rule 10:  KeyWord ::= i m p l i e s
        //
		keywordKind[10] = (TK_implies);
	  
	
        //
        // Rule 11:  KeyWord ::= l e t
        //
		keywordKind[11] = (TK_let);
	  
	
        //
        // Rule 12:  KeyWord ::= i n
        //
		keywordKind[12] = (TK_in);
	  
	
        //
        // Rule 13:  KeyWord ::= t r u e
        //
		keywordKind[13] = (TK_true);
	  
	
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
		keywordKind[14] = (TK_false);
	  
	
        //
        // Rule 15:  KeyWord ::= S e t
        //
		keywordKind[15] = (TK_Set);
	  
	
        //
        // Rule 16:  KeyWord ::= B a g
        //
		keywordKind[16] = (TK_Bag);
	  
	
        //
        // Rule 17:  KeyWord ::= S e q u e n c e
        //
		keywordKind[17] = (TK_Sequence);
	  
	
        //
        // Rule 18:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[18] = (TK_Collection);
	  
	
        //
        // Rule 19:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[19] = (TK_OrderedSet);
	  
	
        //
        // Rule 20:  KeyWord ::= i t e r a t e
        //
		keywordKind[20] = (TK_iterate);
	  
	
        //
        // Rule 21:  KeyWord ::= f o r A l l
        //
		keywordKind[21] = (TK_forAll);
	  
	
        //
        // Rule 22:  KeyWord ::= e x i s t s
        //
		keywordKind[22] = (TK_exists);
	  
	
        //
        // Rule 23:  KeyWord ::= i s U n i q u e
        //
		keywordKind[23] = (TK_isUnique);
	  
	
        //
        // Rule 24:  KeyWord ::= a n y
        //
		keywordKind[24] = (TK_any);
	  
	
        //
        // Rule 25:  KeyWord ::= o n e
        //
		keywordKind[25] = (TK_one);
	  
	
        //
        // Rule 26:  KeyWord ::= c o l l e c t
        //
		keywordKind[26] = (TK_collect);
	  
	
        //
        // Rule 27:  KeyWord ::= s e l e c t
        //
		keywordKind[27] = (TK_select);
	  
	
        //
        // Rule 28:  KeyWord ::= r e j e c t
        //
		keywordKind[28] = (TK_reject);
	  
	
        //
        // Rule 29:  KeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[29] = (TK_collectNested);
	  
	
        //
        // Rule 30:  KeyWord ::= s o r t e d B y
        //
		keywordKind[30] = (TK_sortedBy);
	  
	
        //
        // Rule 31:  KeyWord ::= c l o s u r e
        //
		keywordKind[31] = (TK_closure);
	  
	
        //
        // Rule 32:  KeyWord ::= S t r i n g
        //
		keywordKind[32] = (TK_String);
	  
	
        //
        // Rule 33:  KeyWord ::= I n t e g e r
        //
		keywordKind[33] = (TK_Integer);
	  
	
        //
        // Rule 34:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[34] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 35:  KeyWord ::= R e a l
        //
		keywordKind[35] = (TK_Real);
	  
	
        //
        // Rule 36:  KeyWord ::= B o o l e a n
        //
		keywordKind[36] = (TK_Boolean);
	  
	
        //
        // Rule 37:  KeyWord ::= T u p l e
        //
		keywordKind[37] = (TK_Tuple);
	  
	
        //
        // Rule 38:  KeyWord ::= O c l A n y
        //
		keywordKind[38] = (TK_OclAny);
	  
	
        //
        // Rule 39:  KeyWord ::= O c l V o i d
        //
		keywordKind[39] = (TK_OclVoid);
	  
	
        //
        // Rule 40:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[40] = (TK_OclInvalid);
	  
	
        //
        // Rule 41:  KeyWord ::= n u l l
        //
		keywordKind[41] = (TK_null);
	  
	
        //
        // Rule 42:  KeyWord ::= i n v a l i d
        //
		keywordKind[42] = (TK_invalid);
	  
	
        //
        // Rule 43:  KeyWord ::= i n i t
        //
		keywordKind[43] = (TK_init);
	  
	
        //
        // Rule 44:  KeyWord ::= O c l M e s s a g e
        //
		keywordKind[44] = (TK_OclMessage);
	  
	
        //
        // Rule 45:  KeyWord ::= s t a t i c
        //
		keywordKind[45] = (TK_static);
	  
	
        //
        // Rule 47:  QVTKeyWord ::= w h i l e
        //
		keywordKind[47] = (TK_while);
	  
	
        //
        // Rule 48:  QVTKeyWord ::= o b j e c t
        //
		keywordKind[48] = (TK_object);
	  
	
        //
        // Rule 49:  QVTKeyWord ::= w h e n
        //
		keywordKind[49] = (TK_when);
	  
	
        //
        // Rule 50:  QVTKeyWord ::= v a r
        //
		keywordKind[50] = (TK_var);
	  
	
        //
        // Rule 51:  QVTKeyWord ::= o p p o s i t e s
        //
		keywordKind[51] = (TK_opposites);
	  
	
        //
        // Rule 52:  QVTKeyWord ::= c l a s s
        //
		keywordKind[52] = (TK_class);
	  
	
        //
        // Rule 53:  QVTKeyWord ::= n e w
        //
		keywordKind[53] = (TK_new);
	  
	
        //
        // Rule 54:  QVTKeyWord ::= w i t h
        //
		keywordKind[54] = (TK_with);
	  
	
        //
        // Rule 55:  QVTKeyWord ::= r e s o l v e
        //
		keywordKind[55] = (TK_resolve);
	  
	
        //
        // Rule 56:  QVTKeyWord ::= r e s o l v e o n e
        //
		keywordKind[56] = (TK_resolveone);
	  
	
        //
        // Rule 57:  QVTKeyWord ::= r e s o l v e I n
        //
		keywordKind[57] = (TK_resolveIn);
	  
	
        //
        // Rule 58:  QVTKeyWord ::= r e s o l v e o n e I n
        //
		keywordKind[58] = (TK_resolveoneIn);
	  
	
        //
        // Rule 59:  QVTKeyWord ::= i n v r e s o l v e
        //
		keywordKind[59] = (TK_invresolve);
	  
	
        //
        // Rule 60:  QVTKeyWord ::= i n v r e s o l v e o n e
        //
		keywordKind[60] = (TK_invresolveone);
	  
	
        //
        // Rule 61:  QVTKeyWord ::= i n v r e s o l v e I n
        //
		keywordKind[61] = (TK_invresolveIn);
	  
	
        //
        // Rule 62:  QVTKeyWord ::= i n v r e s o l v e o n e I n
        //
		keywordKind[62] = (TK_invresolveoneIn);
	  
	
        //
        // Rule 63:  QVTKeyWord ::= w h e r e
        //
		keywordKind[63] = (TK_where);
	  
	
        //
        // Rule 64:  QVTKeyWord ::= t h i s
        //
		keywordKind[64] = (TK_this);
	  
	
        //
        // Rule 65:  QVTKeyWord ::= s w i t c h
        //
		keywordKind[65] = (TK_switch);
	  
	
        //
        // Rule 66:  QVTKeyWord ::= c a s e
        //
		keywordKind[66] = (TK_case);
	  
	
        //
        // Rule 67:  QVTKeyWord ::= x s e l e c t
        //
		keywordKind[67] = (TK_xselect);
	  
	
        //
        // Rule 68:  QVTKeyWord ::= x c o l l e c t
        //
		keywordKind[68] = (TK_xcollect);
	  
	
        //
        // Rule 69:  QVTKeyWord ::= s e l e c t O n e
        //
		keywordKind[69] = (TK_selectOne);
	  
	
        //
        // Rule 70:  QVTKeyWord ::= c o l l e c t O n e
        //
		keywordKind[70] = (TK_collectOne);
	  
	
        //
        // Rule 71:  QVTKeyWord ::= c o l l e c t s e l e c t
        //
		keywordKind[71] = (TK_collectselect);
	  
	
        //
        // Rule 72:  QVTKeyWord ::= c o l l e c t s e l e c t O n e
        //
		keywordKind[72] = (TK_collectselectOne);
	  
	
        //
        // Rule 73:  QVTKeyWord ::= f o r E a c h
        //
		keywordKind[73] = (TK_forEach);
	  
	
        //
        // Rule 74:  QVTKeyWord ::= f o r O n e
        //
		keywordKind[74] = (TK_forOne);
	  
	
        //
        // Rule 75:  QVTKeyWord ::= c o m p u t e
        //
		keywordKind[75] = (TK_compute);
	  
	
        //
        // Rule 76:  QVTKeyWord ::= D i c t
        //
		keywordKind[76] = (TK_Dict);
	  
	
        //
        // Rule 77:  QVTKeyWord ::= L i s t
        //
		keywordKind[77] = (TK_List);
	  
	
        //
        // Rule 78:  QVTKeyWord ::= b r e a k
        //
		keywordKind[78] = (TK_break);
	  
	
        //
        // Rule 79:  QVTKeyWord ::= c o m p o s e s
        //
		keywordKind[79] = (TK_composes);
	  
	
        //
        // Rule 80:  QVTKeyWord ::= c o n s t r u c t o r
        //
		keywordKind[80] = (TK_constructor);
	  
	
        //
        // Rule 81:  QVTKeyWord ::= c o n t i n u e
        //
		keywordKind[81] = (TK_continue);
	  
	
        //
        // Rule 82:  QVTKeyWord ::= d a t a t y p e
        //
		keywordKind[82] = (TK_datatype);
	  
	
        //
        // Rule 83:  QVTKeyWord ::= d e f a u l t
        //
		keywordKind[83] = (TK_default);
	  
	
        //
        // Rule 84:  QVTKeyWord ::= d e r i v e d
        //
		keywordKind[84] = (TK_derived);
	  
	
        //
        // Rule 85:  QVTKeyWord ::= d o
        //
		keywordKind[85] = (TK_do);
	  
	
        //
        // Rule 86:  QVTKeyWord ::= e l i f
        //
		keywordKind[86] = (TK_elif);
	  
	
        //
        // Rule 87:  QVTKeyWord ::= e n u m
        //
		keywordKind[87] = (TK_enum);
	  
	
        //
        // Rule 88:  QVTKeyWord ::= e x c e p t
        //
		keywordKind[88] = (TK_except);
	  
	
        //
        // Rule 89:  QVTKeyWord ::= e x c e p t i o n
        //
		keywordKind[89] = (TK_exception);
	  
	
        //
        // Rule 90:  QVTKeyWord ::= f r o m
        //
		keywordKind[90] = (TK_from);
	  
	
        //
        // Rule 91:  QVTKeyWord ::= l i t e r a l
        //
		keywordKind[91] = (TK_literal);
	  
	
        //
        // Rule 92:  QVTKeyWord ::= o r d e r e d
        //
		keywordKind[92] = (TK_ordered);
	  
	
        //
        // Rule 93:  QVTKeyWord ::= p r i m i t i v e
        //
		keywordKind[93] = (TK_primitive);
	  
	
        //
        // Rule 94:  QVTKeyWord ::= r a i s e
        //
		keywordKind[94] = (TK_raise);
	  
	
        //
        // Rule 95:  QVTKeyWord ::= r e a d o n l y
        //
		keywordKind[95] = (TK_readonly);
	  
	
        //
        // Rule 96:  QVTKeyWord ::= r e f e r e n c e s
        //
		keywordKind[96] = (TK_references);
	  
	
        //
        // Rule 97:  QVTKeyWord ::= t a g
        //
		keywordKind[97] = (TK_tag);
	  
	
        //
        // Rule 98:  QVTKeyWord ::= t r y
        //
		keywordKind[98] = (TK_try);
	  
	
        //
        // Rule 99:  QVTKeyWord ::= t y p e d e f
        //
		keywordKind[99] = (TK_typedef);
	  
	
        //
        // Rule 100:  QVTKeyWord ::= u n l i m i t e d
        //
		keywordKind[100] = (TK_unlimited);
	  
	
        //
        // Rule 101:  KeyWord ::= I M P O R T
        //
		keywordKind[101] = (TK_IMPORT);
	
        //
        // Rule 102:  KeyWord ::= E X T E N S I O N
        //
		keywordKind[102] = (TK_EXTENSION);
	
        //
        // Rule 103:  KeyWord ::= A R O U N D
        //
		keywordKind[103] = (TK_AROUND);
	
        //
        // Rule 104:  KeyWord ::= E N D A R O U N D
        //
		keywordKind[104] = (TK_ENDAROUND);
	
        //
        // Rule 105:  KeyWord ::= D E F I N E
        //
		keywordKind[105] = (TK_DEFINE);
	
        //
        // Rule 106:  KeyWord ::= E N D D E F I N E
        //
		keywordKind[106] = (TK_ENDDEFINE);
	
        //
        // Rule 107:  KeyWord ::= E R R O R
        //
		keywordKind[107] = (TK_ERROR);
	
        //
        // Rule 108:  KeyWord ::= E X P A N D
        //
		keywordKind[108] = (TK_EXPAND);
	
        //
        // Rule 109:  KeyWord ::= F O R
        //
		keywordKind[109] = (TK_FOR);
	
        //
        // Rule 110:  KeyWord ::= S E P A R A T O R
        //
		keywordKind[110] = (TK_SEPARATOR);
	
        //
        // Rule 111:  KeyWord ::= A S
        //
		keywordKind[111] = (TK_AS);
	
        //
        // Rule 112:  KeyWord ::= I T E R A T O R
        //
		keywordKind[112] = (TK_ITERATOR);
	
        //
        // Rule 113:  KeyWord ::= F O R E A C H
        //
		keywordKind[113] = (TK_FOREACH);
	
        //
        // Rule 114:  KeyWord ::= E N D F O R E A C H
        //
		keywordKind[114] = (TK_ENDFOREACH);
	
        //
        // Rule 115:  KeyWord ::= F I L E
        //
		keywordKind[115] = (TK_FILE);
	
        //
        // Rule 116:  KeyWord ::= E N D F I L E
        //
		keywordKind[116] = (TK_ENDFILE);
	
        //
        // Rule 117:  KeyWord ::= I F
        //
		keywordKind[117] = (TK_IF);
	
        //
        // Rule 118:  KeyWord ::= E L S E I F
        //
		keywordKind[118] = (TK_ELSEIF);
	
        //
        // Rule 119:  KeyWord ::= E L S E
        //
		keywordKind[119] = (TK_ELSE);
	
        //
        // Rule 120:  KeyWord ::= E N D I F
        //
		keywordKind[120] = (TK_ENDIF);
	
        //
        // Rule 121:  KeyWord ::= L E T
        //
		keywordKind[121] = (TK_LET);
	
        //
        // Rule 122:  KeyWord ::= E N D L E T
        //
		keywordKind[122] = (TK_ENDLET);
	
        //
        // Rule 123:  KeyWord ::= P R O T E C T
        //
		keywordKind[123] = (TK_PROTECT);
	
        //
        // Rule 124:  KeyWord ::= C S T A R T
        //
		keywordKind[124] = (TK_CSTART);
	
        //
        // Rule 125:  KeyWord ::= C E N D
        //
		keywordKind[125] = (TK_CEND);
	
        //
        // Rule 126:  KeyWord ::= I D
        //
		keywordKind[126] = (TK_ID);
	
        //
        // Rule 127:  KeyWord ::= D I S A B L E
        //
		keywordKind[127] = (TK_DISABLE);
	
        //
        // Rule 128:  KeyWord ::= E N D P R O T E C T
        //
		keywordKind[128] = (TK_ENDPROTECT);
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

