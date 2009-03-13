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
    private final int keywordKind[] = new int[136 + 1];

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
        // Rule 2:  KeyWord ::= i n i t
        //
		keywordKind[2] = (TK_init);
	  
	
        //
        // Rule 3:  KeyWord ::= i f
        //
		keywordKind[3] = (TK_if);
	  
	
        //
        // Rule 4:  KeyWord ::= t h e n
        //
		keywordKind[4] = (TK_then);
	  
	
        //
        // Rule 5:  KeyWord ::= e l s e
        //
		keywordKind[5] = (TK_else);
	  
	
        //
        // Rule 6:  KeyWord ::= e n d i f
        //
		keywordKind[6] = (TK_endif);
	  
	
        //
        // Rule 7:  KeyWord ::= a n d
        //
		keywordKind[7] = (TK_and);
	  
	
        //
        // Rule 8:  KeyWord ::= o r
        //
		keywordKind[8] = (TK_or);
	  
	
        //
        // Rule 9:  KeyWord ::= x o r
        //
		keywordKind[9] = (TK_xor);
	  
	
        //
        // Rule 10:  KeyWord ::= n o t
        //
		keywordKind[10] = (TK_not);
	  
	
        //
        // Rule 11:  KeyWord ::= i m p l i e s
        //
		keywordKind[11] = (TK_implies);
	  
	
        //
        // Rule 12:  KeyWord ::= l e t
        //
		keywordKind[12] = (TK_let);
	  
	
        //
        // Rule 13:  KeyWord ::= i n
        //
		keywordKind[13] = (TK_in);
	  
	
        //
        // Rule 14:  KeyWord ::= t r u e
        //
		keywordKind[14] = (TK_true);
	  
	
        //
        // Rule 15:  KeyWord ::= f a l s e
        //
		keywordKind[15] = (TK_false);
	  
	
        //
        // Rule 16:  KeyWord ::= S e t
        //
		keywordKind[16] = (TK_Set);
	  
	
        //
        // Rule 17:  KeyWord ::= B a g
        //
		keywordKind[17] = (TK_Bag);
	  
	
        //
        // Rule 18:  KeyWord ::= S e q u e n c e
        //
		keywordKind[18] = (TK_Sequence);
	  
	
        //
        // Rule 19:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[19] = (TK_Collection);
	  
	
        //
        // Rule 20:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[20] = (TK_OrderedSet);
	  
	
        //
        // Rule 21:  KeyWord ::= i t e r a t e
        //
		keywordKind[21] = (TK_iterate);
	  
	
        //
        // Rule 22:  KeyWord ::= f o r A l l
        //
		keywordKind[22] = (TK_forAll);
	  
	
        //
        // Rule 23:  KeyWord ::= e x i s t s
        //
		keywordKind[23] = (TK_exists);
	  
	
        //
        // Rule 24:  KeyWord ::= i s U n i q u e
        //
		keywordKind[24] = (TK_isUnique);
	  
	
        //
        // Rule 25:  KeyWord ::= a n y
        //
		keywordKind[25] = (TK_any);
	  
	
        //
        // Rule 26:  KeyWord ::= o n e
        //
		keywordKind[26] = (TK_one);
	  
	
        //
        // Rule 27:  KeyWord ::= c o l l e c t
        //
		keywordKind[27] = (TK_collect);
	  
	
        //
        // Rule 28:  KeyWord ::= s e l e c t
        //
		keywordKind[28] = (TK_select);
	  
	
        //
        // Rule 29:  KeyWord ::= r e j e c t
        //
		keywordKind[29] = (TK_reject);
	  
	
        //
        // Rule 30:  KeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[30] = (TK_collectNested);
	  
	
        //
        // Rule 31:  KeyWord ::= s o r t e d B y
        //
		keywordKind[31] = (TK_sortedBy);
	  
	
        //
        // Rule 32:  KeyWord ::= c l o s u r e
        //
		keywordKind[32] = (TK_closure);
	  
	
        //
        // Rule 33:  KeyWord ::= o c l I s K i n d O f
        //
		keywordKind[33] = (TK_oclIsKindOf);
	  
	
        //
        // Rule 34:  KeyWord ::= o c l I s T y p e O f
        //
		keywordKind[34] = (TK_oclIsTypeOf);
	  
	
        //
        // Rule 35:  KeyWord ::= o c l A s T y p e
        //
		keywordKind[35] = (TK_oclAsType);
	  
	
        //
        // Rule 36:  KeyWord ::= o c l I s N e w
        //
		keywordKind[36] = (TK_oclIsNew);
	  
	
        //
        // Rule 37:  KeyWord ::= o c l I s U n d e f i n e d
        //
		keywordKind[37] = (TK_oclIsUndefined);
	  
	
        //
        // Rule 38:  KeyWord ::= o c l I s I n v a l i d
        //
		keywordKind[38] = (TK_oclIsInvalid);
	  
	
        //
        // Rule 39:  KeyWord ::= o c l I s I n S t a t e
        //
		keywordKind[39] = (TK_oclIsInState);
	  
	
        //
        // Rule 40:  KeyWord ::= a l l I n s t a n c e s
        //
		keywordKind[40] = (TK_allInstances);
	  
	
        //
        // Rule 41:  KeyWord ::= S t r i n g
        //
		keywordKind[41] = (TK_String);
	  
	
        //
        // Rule 42:  KeyWord ::= I n t e g e r
        //
		keywordKind[42] = (TK_Integer);
	  
	
        //
        // Rule 43:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[43] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 44:  KeyWord ::= R e a l
        //
		keywordKind[44] = (TK_Real);
	  
	
        //
        // Rule 45:  KeyWord ::= B o o l e a n
        //
		keywordKind[45] = (TK_Boolean);
	  
	
        //
        // Rule 46:  KeyWord ::= T u p l e
        //
		keywordKind[46] = (TK_Tuple);
	  
	
        //
        // Rule 47:  KeyWord ::= O c l A n y
        //
		keywordKind[47] = (TK_OclAny);
	  
	
        //
        // Rule 48:  KeyWord ::= O c l V o i d
        //
		keywordKind[48] = (TK_OclVoid);
	  
	
        //
        // Rule 49:  KeyWord ::= I n v a l i d
        //
		keywordKind[49] = (TK_Invalid);
	  
	
        //
        // Rule 50:  KeyWord ::= O c l M e s s a g e
        //
		keywordKind[50] = (TK_OclMessage);
	  
	
        //
        // Rule 51:  KeyWord ::= n u l l
        //
		keywordKind[51] = (TK_null);
	  
	
        //
        // Rule 52:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[52] = (TK_OclInvalid);
	  
	
        //
        // Rule 54:  QVTKeyWord ::= w h i l e
        //
		keywordKind[54] = (TK_while);
	  
	
        //
        // Rule 55:  QVTKeyWord ::= o b j e c t
        //
		keywordKind[55] = (TK_object);
	  
	
        //
        // Rule 56:  QVTKeyWord ::= w h e n
        //
		keywordKind[56] = (TK_when);
	  
	
        //
        // Rule 57:  QVTKeyWord ::= v a r
        //
		keywordKind[57] = (TK_var);
	  
	
        //
        // Rule 58:  QVTKeyWord ::= o p p o s i t e s
        //
		keywordKind[58] = (TK_opposites);
	  
	
        //
        // Rule 59:  QVTKeyWord ::= c l a s s
        //
		keywordKind[59] = (TK_class);
	  
	
        //
        // Rule 60:  QVTKeyWord ::= n e w
        //
		keywordKind[60] = (TK_new);
	  
	
        //
        // Rule 61:  QVTKeyWord ::= w i t h
        //
		keywordKind[61] = (TK_with);
	  
	
        //
        // Rule 62:  QVTKeyWord ::= r e s o l v e
        //
		keywordKind[62] = (TK_resolve);
	  
	
        //
        // Rule 63:  QVTKeyWord ::= r e s o l v e o n e
        //
		keywordKind[63] = (TK_resolveone);
	  
	
        //
        // Rule 64:  QVTKeyWord ::= r e s o l v e I n
        //
		keywordKind[64] = (TK_resolveIn);
	  
	
        //
        // Rule 65:  QVTKeyWord ::= r e s o l v e o n e I n
        //
		keywordKind[65] = (TK_resolveoneIn);
	  
	
        //
        // Rule 66:  QVTKeyWord ::= i n v r e s o l v e
        //
		keywordKind[66] = (TK_invresolve);
	  
	
        //
        // Rule 67:  QVTKeyWord ::= i n v r e s o l v e o n e
        //
		keywordKind[67] = (TK_invresolveone);
	  
	
        //
        // Rule 68:  QVTKeyWord ::= i n v r e s o l v e I n
        //
		keywordKind[68] = (TK_invresolveIn);
	  
	
        //
        // Rule 69:  QVTKeyWord ::= i n v r e s o l v e o n e I n
        //
		keywordKind[69] = (TK_invresolveoneIn);
	  
	
        //
        // Rule 70:  QVTKeyWord ::= w h e r e
        //
		keywordKind[70] = (TK_where);
	  
	
        //
        // Rule 71:  QVTKeyWord ::= t h i s
        //
		keywordKind[71] = (TK_this);
	  
	
        //
        // Rule 72:  QVTKeyWord ::= s w i t c h
        //
		keywordKind[72] = (TK_switch);
	  
	
        //
        // Rule 73:  QVTKeyWord ::= c a s e
        //
		keywordKind[73] = (TK_case);
	  
	
        //
        // Rule 74:  QVTKeyWord ::= x s e l e c t
        //
		keywordKind[74] = (TK_xselect);
	  
	
        //
        // Rule 75:  QVTKeyWord ::= x c o l l e c t
        //
		keywordKind[75] = (TK_xcollect);
	  
	
        //
        // Rule 76:  QVTKeyWord ::= s e l e c t O n e
        //
		keywordKind[76] = (TK_selectOne);
	  
	
        //
        // Rule 77:  QVTKeyWord ::= c o l l e c t O n e
        //
		keywordKind[77] = (TK_collectOne);
	  
	
        //
        // Rule 78:  QVTKeyWord ::= c o l l e c t s e l e c t
        //
		keywordKind[78] = (TK_collectselect);
	  
	
        //
        // Rule 79:  QVTKeyWord ::= c o l l e c t s e l e c t O n e
        //
		keywordKind[79] = (TK_collectselectOne);
	  
	
        //
        // Rule 80:  QVTKeyWord ::= f o r E a c h
        //
		keywordKind[80] = (TK_forEach);
	  
	
        //
        // Rule 81:  QVTKeyWord ::= f o r O n e
        //
		keywordKind[81] = (TK_forOne);
	  
	
        //
        // Rule 82:  QVTKeyWord ::= c o m p u t e
        //
		keywordKind[82] = (TK_compute);
	  
	
        //
        // Rule 83:  QVTKeyWord ::= D i c t
        //
		keywordKind[83] = (TK_Dict);
	  
	
        //
        // Rule 84:  QVTKeyWord ::= L i s t
        //
		keywordKind[84] = (TK_List);
	  
	
        //
        // Rule 85:  QVTKeyWord ::= b r e a k
        //
		keywordKind[85] = (TK_break);
	  
	
        //
        // Rule 86:  QVTKeyWord ::= c o m p o s e s
        //
		keywordKind[86] = (TK_composes);
	  
	
        //
        // Rule 87:  QVTKeyWord ::= c o n s t r u c t o r
        //
		keywordKind[87] = (TK_constructor);
	  
	
        //
        // Rule 88:  QVTKeyWord ::= c o n t i n u e
        //
		keywordKind[88] = (TK_continue);
	  
	
        //
        // Rule 89:  QVTKeyWord ::= d a t a t y p e
        //
		keywordKind[89] = (TK_datatype);
	  
	
        //
        // Rule 90:  QVTKeyWord ::= d e f a u l t
        //
		keywordKind[90] = (TK_default);
	  
	
        //
        // Rule 91:  QVTKeyWord ::= d e r i v e d
        //
		keywordKind[91] = (TK_derived);
	  
	
        //
        // Rule 92:  QVTKeyWord ::= d o
        //
		keywordKind[92] = (TK_do);
	  
	
        //
        // Rule 93:  QVTKeyWord ::= e l i f
        //
		keywordKind[93] = (TK_elif);
	  
	
        //
        // Rule 94:  QVTKeyWord ::= e n u m
        //
		keywordKind[94] = (TK_enum);
	  
	
        //
        // Rule 95:  QVTKeyWord ::= e x c e p t
        //
		keywordKind[95] = (TK_except);
	  
	
        //
        // Rule 96:  QVTKeyWord ::= e x c e p t i o n
        //
		keywordKind[96] = (TK_exception);
	  
	
        //
        // Rule 97:  QVTKeyWord ::= f r o m
        //
		keywordKind[97] = (TK_from);
	  
	
        //
        // Rule 98:  QVTKeyWord ::= l i t e r a l
        //
		keywordKind[98] = (TK_literal);
	  
	
        //
        // Rule 99:  QVTKeyWord ::= o r d e r e d
        //
		keywordKind[99] = (TK_ordered);
	  
	
        //
        // Rule 100:  QVTKeyWord ::= p r i m i t i v e
        //
		keywordKind[100] = (TK_primitive);
	  
	
        //
        // Rule 101:  QVTKeyWord ::= r a i s e
        //
		keywordKind[101] = (TK_raise);
	  
	
        //
        // Rule 102:  QVTKeyWord ::= r e a d o n l y
        //
		keywordKind[102] = (TK_readonly);
	  
	
        //
        // Rule 103:  QVTKeyWord ::= r e f e r e n c e s
        //
		keywordKind[103] = (TK_references);
	  
	
        //
        // Rule 104:  QVTKeyWord ::= t a g
        //
		keywordKind[104] = (TK_tag);
	  
	
        //
        // Rule 105:  QVTKeyWord ::= t r y
        //
		keywordKind[105] = (TK_try);
	  
	
        //
        // Rule 106:  QVTKeyWord ::= t y p e d e f
        //
		keywordKind[106] = (TK_typedef);
	  
	
        //
        // Rule 107:  QVTKeyWord ::= u n l i m i t e d
        //
		keywordKind[107] = (TK_unlimited);
	  
	
        //
        // Rule 108:  QVTKeyWord ::= i n v a l i d
        //
		keywordKind[108] = (TK_invalid);
	  
	
        //
        // Rule 109:  KeyWord ::= I M P O R T
        //
		keywordKind[109] = (TK_IMPORT);
	
        //
        // Rule 110:  KeyWord ::= E X T E N S I O N
        //
		keywordKind[110] = (TK_EXTENSION);
	
        //
        // Rule 111:  KeyWord ::= A R O U N D
        //
		keywordKind[111] = (TK_AROUND);
	
        //
        // Rule 112:  KeyWord ::= E N D A R O U N D
        //
		keywordKind[112] = (TK_ENDAROUND);
	
        //
        // Rule 113:  KeyWord ::= D E F I N E
        //
		keywordKind[113] = (TK_DEFINE);
	
        //
        // Rule 114:  KeyWord ::= E N D D E F I N E
        //
		keywordKind[114] = (TK_ENDDEFINE);
	
        //
        // Rule 115:  KeyWord ::= E R R O R
        //
		keywordKind[115] = (TK_ERROR);
	
        //
        // Rule 116:  KeyWord ::= E X P A N D
        //
		keywordKind[116] = (TK_EXPAND);
	
        //
        // Rule 117:  KeyWord ::= F O R
        //
		keywordKind[117] = (TK_FOR);
	
        //
        // Rule 118:  KeyWord ::= S E P A R A T O R
        //
		keywordKind[118] = (TK_SEPARATOR);
	
        //
        // Rule 119:  KeyWord ::= A S
        //
		keywordKind[119] = (TK_AS);
	
        //
        // Rule 120:  KeyWord ::= I T E R A T O R
        //
		keywordKind[120] = (TK_ITERATOR);
	
        //
        // Rule 121:  KeyWord ::= F O R E A C H
        //
		keywordKind[121] = (TK_FOREACH);
	
        //
        // Rule 122:  KeyWord ::= E N D F O R E A C H
        //
		keywordKind[122] = (TK_ENDFOREACH);
	
        //
        // Rule 123:  KeyWord ::= F I L E
        //
		keywordKind[123] = (TK_FILE);
	
        //
        // Rule 124:  KeyWord ::= E N D F I L E
        //
		keywordKind[124] = (TK_ENDFILE);
	
        //
        // Rule 125:  KeyWord ::= I F
        //
		keywordKind[125] = (TK_IF);
	
        //
        // Rule 126:  KeyWord ::= E L S E I F
        //
		keywordKind[126] = (TK_ELSEIF);
	
        //
        // Rule 127:  KeyWord ::= E L S E
        //
		keywordKind[127] = (TK_ELSE);
	
        //
        // Rule 128:  KeyWord ::= E N D I F
        //
		keywordKind[128] = (TK_ENDIF);
	
        //
        // Rule 129:  KeyWord ::= L E T
        //
		keywordKind[129] = (TK_LET);
	
        //
        // Rule 130:  KeyWord ::= E N D L E T
        //
		keywordKind[130] = (TK_ENDLET);
	
        //
        // Rule 131:  KeyWord ::= P R O T E C T
        //
		keywordKind[131] = (TK_PROTECT);
	
        //
        // Rule 132:  KeyWord ::= C S T A R T
        //
		keywordKind[132] = (TK_CSTART);
	
        //
        // Rule 133:  KeyWord ::= C E N D
        //
		keywordKind[133] = (TK_CEND);
	
        //
        // Rule 134:  KeyWord ::= I D
        //
		keywordKind[134] = (TK_ID);
	
        //
        // Rule 135:  KeyWord ::= D I S A B L E
        //
		keywordKind[135] = (TK_DISABLE);
	
        //
        // Rule 136:  KeyWord ::= E N D P R O T E C T
        //
		keywordKind[136] = (TK_ENDPROTECT);
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

