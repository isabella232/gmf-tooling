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
    private final int keywordKind[] = new int[149 + 1];

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
        tokenKind['$'] = XpandKWLexersym.Char_DollarSign;
        tokenKind['%'] = XpandKWLexersym.Char_Percent;
        tokenKind['_'] = XpandKWLexersym.Char__;

        tokenKind['a'] = XpandKWLexersym.Char_a;
        tokenKind['b'] = XpandKWLexersym.Char_b;
        tokenKind['c'] = XpandKWLexersym.Char_c;
        tokenKind['d'] = XpandKWLexersym.Char_d;
        tokenKind['e'] = XpandKWLexersym.Char_e;
        tokenKind['f'] = XpandKWLexersym.Char_f;
        tokenKind['g'] = XpandKWLexersym.Char_g;
        tokenKind['h'] = XpandKWLexersym.Char_h;
        tokenKind['i'] = XpandKWLexersym.Char_i;
        tokenKind['j'] = XpandKWLexersym.Char_j;
        tokenKind['k'] = XpandKWLexersym.Char_k;
        tokenKind['l'] = XpandKWLexersym.Char_l;
        tokenKind['m'] = XpandKWLexersym.Char_m;
        tokenKind['n'] = XpandKWLexersym.Char_n;
        tokenKind['o'] = XpandKWLexersym.Char_o;
        tokenKind['p'] = XpandKWLexersym.Char_p;
        tokenKind['q'] = XpandKWLexersym.Char_q;
        tokenKind['r'] = XpandKWLexersym.Char_r;
        tokenKind['s'] = XpandKWLexersym.Char_s;
        tokenKind['t'] = XpandKWLexersym.Char_t;
        tokenKind['u'] = XpandKWLexersym.Char_u;
        tokenKind['v'] = XpandKWLexersym.Char_v;
        tokenKind['w'] = XpandKWLexersym.Char_w;
        tokenKind['x'] = XpandKWLexersym.Char_x;
        tokenKind['y'] = XpandKWLexersym.Char_y;
        tokenKind['z'] = XpandKWLexersym.Char_z;

        tokenKind['A'] = XpandKWLexersym.Char_A;
        tokenKind['B'] = XpandKWLexersym.Char_B;
        tokenKind['C'] = XpandKWLexersym.Char_C;
        tokenKind['D'] = XpandKWLexersym.Char_D;
        tokenKind['E'] = XpandKWLexersym.Char_E;
        tokenKind['F'] = XpandKWLexersym.Char_F;
        tokenKind['G'] = XpandKWLexersym.Char_G;
        tokenKind['H'] = XpandKWLexersym.Char_H;
        tokenKind['I'] = XpandKWLexersym.Char_I;
        tokenKind['J'] = XpandKWLexersym.Char_J;
        tokenKind['K'] = XpandKWLexersym.Char_K;
        tokenKind['L'] = XpandKWLexersym.Char_L;
        tokenKind['M'] = XpandKWLexersym.Char_M;
        tokenKind['N'] = XpandKWLexersym.Char_N;
        tokenKind['O'] = XpandKWLexersym.Char_O;
        tokenKind['P'] = XpandKWLexersym.Char_P;
        tokenKind['Q'] = XpandKWLexersym.Char_Q;
        tokenKind['R'] = XpandKWLexersym.Char_R;
        tokenKind['S'] = XpandKWLexersym.Char_S;
        tokenKind['T'] = XpandKWLexersym.Char_T;
        tokenKind['U'] = XpandKWLexersym.Char_U;
        tokenKind['V'] = XpandKWLexersym.Char_V;
        tokenKind['W'] = XpandKWLexersym.Char_W;
        tokenKind['X'] = XpandKWLexersym.Char_X;
        tokenKind['Y'] = XpandKWLexersym.Char_Y;
        tokenKind['Z'] = XpandKWLexersym.Char_Z;
    };

    final int getKind(char c)
    {
        return (((c & 0xFFFFFF80) == 0) /* 0 <= c < 128? */ ? tokenKind[c] : 0);
    }


    public XpandKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= s e l f
        //
		keywordKind[1] = (XpandParsersym.TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i f
        //
		keywordKind[2] = (XpandParsersym.TK_if);
	  
	
        //
        // Rule 3:  KeyWord ::= t h e n
        //
		keywordKind[3] = (XpandParsersym.TK_then);
	  
	
        //
        // Rule 4:  KeyWord ::= e l s e
        //
		keywordKind[4] = (XpandParsersym.TK_else);
	  
	
        //
        // Rule 5:  KeyWord ::= e n d i f
        //
		keywordKind[5] = (XpandParsersym.TK_endif);
	  
	
        //
        // Rule 6:  KeyWord ::= a n d
        //
		keywordKind[6] = (XpandParsersym.TK_and);
	  
	
        //
        // Rule 7:  KeyWord ::= o r
        //
		keywordKind[7] = (XpandParsersym.TK_or);
	  
	
        //
        // Rule 8:  KeyWord ::= x o r
        //
		keywordKind[8] = (XpandParsersym.TK_xor);
	  
	
        //
        // Rule 9:  KeyWord ::= n o t
        //
		keywordKind[9] = (XpandParsersym.TK_not);
	  
	
        //
        // Rule 10:  KeyWord ::= i m p l i e s
        //
		keywordKind[10] = (XpandParsersym.TK_implies);
	  
	
        //
        // Rule 11:  KeyWord ::= l e t
        //
		keywordKind[11] = (XpandParsersym.TK_let);
	  
	
        //
        // Rule 12:  KeyWord ::= i n
        //
		keywordKind[12] = (XpandParsersym.TK_in);
	  
	
        //
        // Rule 13:  KeyWord ::= t r u e
        //
		keywordKind[13] = (XpandParsersym.TK_true);
	  
	
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
		keywordKind[14] = (XpandParsersym.TK_false);
	  
	
        //
        // Rule 15:  KeyWord ::= S e t
        //
		keywordKind[15] = (XpandParsersym.TK_Set);
	  
	
        //
        // Rule 16:  KeyWord ::= B a g
        //
		keywordKind[16] = (XpandParsersym.TK_Bag);
	  
	
        //
        // Rule 17:  KeyWord ::= S e q u e n c e
        //
		keywordKind[17] = (XpandParsersym.TK_Sequence);
	  
	
        //
        // Rule 18:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[18] = (XpandParsersym.TK_Collection);
	  
	
        //
        // Rule 19:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[19] = (XpandParsersym.TK_OrderedSet);
	  
	
        //
        // Rule 20:  KeyWord ::= S t r i n g
        //
		keywordKind[20] = (XpandParsersym.TK_String);
	  
	
        //
        // Rule 21:  KeyWord ::= I n t e g e r
        //
		keywordKind[21] = (XpandParsersym.TK_Integer);
	  
	
        //
        // Rule 22:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[22] = (XpandParsersym.TK_UnlimitedNatural);
	  
	
        //
        // Rule 23:  KeyWord ::= R e a l
        //
		keywordKind[23] = (XpandParsersym.TK_Real);
	  
	
        //
        // Rule 24:  KeyWord ::= B o o l e a n
        //
		keywordKind[24] = (XpandParsersym.TK_Boolean);
	  
	
        //
        // Rule 25:  KeyWord ::= T u p l e
        //
		keywordKind[25] = (XpandParsersym.TK_Tuple);
	  
	
        //
        // Rule 26:  KeyWord ::= O c l A n y
        //
		keywordKind[26] = (XpandParsersym.TK_OclAny);
	  
	
        //
        // Rule 27:  KeyWord ::= O c l V o i d
        //
		keywordKind[27] = (XpandParsersym.TK_OclVoid);
	  
	
        //
        // Rule 28:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[28] = (XpandParsersym.TK_OclInvalid);
	  
	
        //
        // Rule 29:  KeyWord ::= n u l l
        //
		keywordKind[29] = (XpandParsersym.TK_null);
	  
	
        //
        // Rule 30:  KeyWord ::= i n v a l i d
        //
		keywordKind[30] = (XpandParsersym.TK_invalid);
	  
	
        //
        // Rule 32:  ImperativeOCLKeyWord ::= D i c t
        //
		keywordKind[32] = (XpandParsersym.TK_Dict);
	  
	
        //
        // Rule 33:  ImperativeOCLKeyWord ::= L i s t
        //
		keywordKind[33] = (XpandParsersym.TK_List);
	  
	
        //
        // Rule 34:  ImperativeOCLKeyWord ::= b r e a k
        //
		keywordKind[34] = (XpandParsersym.TK_break);
	  
	
        //
        // Rule 35:  ImperativeOCLKeyWord ::= s w i t c h
        //
		keywordKind[35] = (XpandParsersym.TK_switch);
	  
	
        //
        // Rule 36:  ImperativeOCLKeyWord ::= c a s e
        //
		keywordKind[36] = (XpandParsersym.TK_case);
	  
	
        //
        // Rule 37:  ImperativeOCLKeyWord ::= x s e l e c t
        //
		keywordKind[37] = (XpandParsersym.TK_xselect);
	  
	
        //
        // Rule 38:  ImperativeOCLKeyWord ::= x c o l l e c t
        //
		keywordKind[38] = (XpandParsersym.TK_xcollect);
	  
	
        //
        // Rule 39:  ImperativeOCLKeyWord ::= s e l e c t O n e
        //
		keywordKind[39] = (XpandParsersym.TK_selectOne);
	  
	
        //
        // Rule 40:  ImperativeOCLKeyWord ::= c o l l e c t O n e
        //
		keywordKind[40] = (XpandParsersym.TK_collectOne);
	  
	
        //
        // Rule 41:  ImperativeOCLKeyWord ::= c o l l e c t s e l e c t
        //
		keywordKind[41] = (XpandParsersym.TK_collectselect);
	  
	
        //
        // Rule 42:  ImperativeOCLKeyWord ::= c o l l e c t s e l e c t O n e
        //
		keywordKind[42] = (XpandParsersym.TK_collectselectOne);
	  
	
        //
        // Rule 43:  ImperativeOCLKeyWord ::= f o r E a c h
        //
		keywordKind[43] = (XpandParsersym.TK_forEach);
	  
	
        //
        // Rule 44:  ImperativeOCLKeyWord ::= f o r O n e
        //
		keywordKind[44] = (XpandParsersym.TK_forOne);
	  
	
        //
        // Rule 45:  ImperativeOCLKeyWord ::= c o m p u t e
        //
		keywordKind[45] = (XpandParsersym.TK_compute);
	  
	
        //
        // Rule 46:  ImperativeOCLKeyWord ::= r e t u r n
        //
		keywordKind[46] = (XpandParsersym.TK_return);
	  
	
        //
        // Rule 47:  ImperativeOCLKeyWord ::= v a r
        //
		keywordKind[47] = (XpandParsersym.TK_var);
	  
	
        //
        // Rule 48:  ImperativeOCLKeyWord ::= w h i l e
        //
		keywordKind[48] = (XpandParsersym.TK_while);
	  
	
        //
        // Rule 49:  ImperativeOCLKeyWord ::= c o n t i n u e
        //
		keywordKind[49] = (XpandParsersym.TK_continue);
	  
	
        //
        // Rule 50:  ImperativeOCLKeyWord ::= l o g
        //
		keywordKind[50] = (XpandParsersym.TK_log);
	  
	
        //
        // Rule 51:  ImperativeOCLKeyWord ::= a s s e r t
        //
		keywordKind[51] = (XpandParsersym.TK_assert);
	  
	
        //
        // Rule 52:  ImperativeOCLKeyWord ::= w i t h
        //
		keywordKind[52] = (XpandParsersym.TK_with);
	  
	
        //
        // Rule 53:  ImperativeOCLKeyWord ::= n e w
        //
		keywordKind[53] = (XpandParsersym.TK_new);
	  
	
        //
        // Rule 55:  QVTOKeyWord ::= s t a t i c
        //
		keywordKind[55] = (XpandParsersym.TK_static);
	  
	
        //
        // Rule 56:  QVTOKeyWord ::= i n i t
        //
		keywordKind[56] = (XpandParsersym.TK_init);
	  
	
        //
        // Rule 57:  QVTOKeyWord ::= e n d
        //
		keywordKind[57] = (XpandParsersym.TK_end);
	  
	
        //
        // Rule 58:  QVTOKeyWord ::= o u t
        //
		keywordKind[58] = (XpandParsersym.TK_out);
	  
	
        //
        // Rule 59:  QVTOKeyWord ::= o b j e c t
        //
		keywordKind[59] = (XpandParsersym.TK_object);
	  
	
        //
        // Rule 60:  QVTOKeyWord ::= t r a n s f o r m a t i o n
        //
		keywordKind[60] = (XpandParsersym.TK_transformation);
	  
	
        //
        // Rule 61:  QVTOKeyWord ::= i m p o r t
        //
		keywordKind[61] = (XpandParsersym.TK_import);
	  
	
        //
        // Rule 62:  QVTOKeyWord ::= l i b r a r y
        //
		keywordKind[62] = (XpandParsersym.TK_library);
	  
	
        //
        // Rule 63:  QVTOKeyWord ::= m e t a m o d e l
        //
		keywordKind[63] = (XpandParsersym.TK_metamodel);
	  
	
        //
        // Rule 64:  QVTOKeyWord ::= d i s j u n c t s
        //
		keywordKind[64] = (XpandParsersym.TK_disjuncts);
	  
	
        //
        // Rule 65:  QVTOKeyWord ::= m e r g e s
        //
		keywordKind[65] = (XpandParsersym.TK_merges);
	  
	
        //
        // Rule 66:  QVTOKeyWord ::= i n h e r i t s
        //
		keywordKind[66] = (XpandParsersym.TK_inherits);
	  
	
        //
        // Rule 67:  QVTOKeyWord ::= r e n a m e
        //
		keywordKind[67] = (XpandParsersym.TK_rename);
	  
	
        //
        // Rule 68:  QVTOKeyWord ::= m a p p i n g
        //
		keywordKind[68] = (XpandParsersym.TK_mapping);
	  
	
        //
        // Rule 69:  QVTOKeyWord ::= q u e r y
        //
		keywordKind[69] = (XpandParsersym.TK_query);
	  
	
        //
        // Rule 70:  QVTOKeyWord ::= h e l p e r
        //
		keywordKind[70] = (XpandParsersym.TK_helper);
	  
	
        //
        // Rule 71:  QVTOKeyWord ::= i n o u t
        //
		keywordKind[71] = (XpandParsersym.TK_inout);
	  
	
        //
        // Rule 72:  QVTOKeyWord ::= w h e n
        //
		keywordKind[72] = (XpandParsersym.TK_when);
	  
	
        //
        // Rule 73:  QVTOKeyWord ::= c o n f i g u r a t i o n
        //
		keywordKind[73] = (XpandParsersym.TK_configuration);
	  
	
        //
        // Rule 74:  QVTOKeyWord ::= p o p u l a t i o n
        //
		keywordKind[74] = (XpandParsersym.TK_population);
	  
	
        //
        // Rule 75:  QVTOKeyWord ::= i n t e r m e d i a t e
        //
		keywordKind[75] = (XpandParsersym.TK_intermediate);
	  
	
        //
        // Rule 76:  QVTOKeyWord ::= p r o p e r t y
        //
		keywordKind[76] = (XpandParsersym.TK_property);
	  
	
        //
        // Rule 77:  QVTOKeyWord ::= o p p o s i t e s
        //
		keywordKind[77] = (XpandParsersym.TK_opposites);
	  
	
        //
        // Rule 78:  QVTOKeyWord ::= c l a s s
        //
		keywordKind[78] = (XpandParsersym.TK_class);
	  
	
        //
        // Rule 79:  QVTOKeyWord ::= m a p
        //
		keywordKind[79] = (XpandParsersym.TK_map);
	  
	
        //
        // Rule 80:  QVTOKeyWord ::= x m a p
        //
		keywordKind[80] = (XpandParsersym.TK_xmap);
	  
	
        //
        // Rule 81:  QVTOKeyWord ::= l a t e
        //
		keywordKind[81] = (XpandParsersym.TK_late);
	  
	
        //
        // Rule 82:  QVTOKeyWord ::= r e s o l v e
        //
		keywordKind[82] = (XpandParsersym.TK_resolve);
	  
	
        //
        // Rule 83:  QVTOKeyWord ::= r e s o l v e o n e
        //
		keywordKind[83] = (XpandParsersym.TK_resolveone);
	  
	
        //
        // Rule 84:  QVTOKeyWord ::= r e s o l v e I n
        //
		keywordKind[84] = (XpandParsersym.TK_resolveIn);
	  
	
        //
        // Rule 85:  QVTOKeyWord ::= r e s o l v e o n e I n
        //
		keywordKind[85] = (XpandParsersym.TK_resolveoneIn);
	  
	
        //
        // Rule 86:  QVTOKeyWord ::= i n v r e s o l v e
        //
		keywordKind[86] = (XpandParsersym.TK_invresolve);
	  
	
        //
        // Rule 87:  QVTOKeyWord ::= i n v r e s o l v e o n e
        //
		keywordKind[87] = (XpandParsersym.TK_invresolveone);
	  
	
        //
        // Rule 88:  QVTOKeyWord ::= i n v r e s o l v e I n
        //
		keywordKind[88] = (XpandParsersym.TK_invresolveIn);
	  
	
        //
        // Rule 89:  QVTOKeyWord ::= i n v r e s o l v e o n e I n
        //
		keywordKind[89] = (XpandParsersym.TK_invresolveoneIn);
	  
	
        //
        // Rule 90:  QVTOKeyWord ::= m o d e l t y p e
        //
		keywordKind[90] = (XpandParsersym.TK_modeltype);
	  
	
        //
        // Rule 91:  QVTOKeyWord ::= u s e s
        //
		keywordKind[91] = (XpandParsersym.TK_uses);
	  
	
        //
        // Rule 92:  QVTOKeyWord ::= w h e r e
        //
		keywordKind[92] = (XpandParsersym.TK_where);
	  
	
        //
        // Rule 93:  QVTOKeyWord ::= r e f i n e s
        //
		keywordKind[93] = (XpandParsersym.TK_refines);
	  
	
        //
        // Rule 94:  QVTOKeyWord ::= a c c e s s
        //
		keywordKind[94] = (XpandParsersym.TK_access);
	  
	
        //
        // Rule 95:  QVTOKeyWord ::= e x t e n d s
        //
		keywordKind[95] = (XpandParsersym.TK_extends);
	  
	
        //
        // Rule 96:  QVTOKeyWord ::= b l a c k b o x
        //
		keywordKind[96] = (XpandParsersym.TK_blackbox);
	  
	
        //
        // Rule 97:  QVTOKeyWord ::= a b s t r a c t
        //
		keywordKind[97] = (XpandParsersym.TK_abstract);
	  
	
        //
        // Rule 98:  QVTOKeyWord ::= r e s u l t
        //
		keywordKind[98] = (XpandParsersym.TK_result);
	  
	
        //
        // Rule 99:  QVTOKeyWord ::= m a i n
        //
		keywordKind[99] = (XpandParsersym.TK_main);
	  
	
        //
        // Rule 100:  QVTOKeyWord ::= t h i s
        //
		keywordKind[100] = (XpandParsersym.TK_this);
	  
	
        //
        // Rule 101:  QVTOKeyWord ::= c o m p o s e s
        //
		keywordKind[101] = (XpandParsersym.TK_composes);
	  
	
        //
        // Rule 102:  QVTOKeyWord ::= c o n s t r u c t o r
        //
		keywordKind[102] = (XpandParsersym.TK_constructor);
	  
	
        //
        // Rule 103:  QVTOKeyWord ::= d a t a t y p e
        //
		keywordKind[103] = (XpandParsersym.TK_datatype);
	  
	
        //
        // Rule 104:  QVTOKeyWord ::= d e f a u l t
        //
		keywordKind[104] = (XpandParsersym.TK_default);
	  
	
        //
        // Rule 105:  QVTOKeyWord ::= d e r i v e d
        //
		keywordKind[105] = (XpandParsersym.TK_derived);
	  
	
        //
        // Rule 106:  QVTOKeyWord ::= d o
        //
		keywordKind[106] = (XpandParsersym.TK_do);
	  
	
        //
        // Rule 107:  QVTOKeyWord ::= e l i f
        //
		keywordKind[107] = (XpandParsersym.TK_elif);
	  
	
        //
        // Rule 108:  QVTOKeyWord ::= e n u m
        //
		keywordKind[108] = (XpandParsersym.TK_enum);
	  
	
        //
        // Rule 109:  QVTOKeyWord ::= e x c e p t
        //
		keywordKind[109] = (XpandParsersym.TK_except);
	  
	
        //
        // Rule 110:  QVTOKeyWord ::= e x c e p t i o n
        //
		keywordKind[110] = (XpandParsersym.TK_exception);
	  
	
        //
        // Rule 111:  QVTOKeyWord ::= f r o m
        //
		keywordKind[111] = (XpandParsersym.TK_from);
	  
	
        //
        // Rule 112:  QVTOKeyWord ::= l i t e r a l
        //
		keywordKind[112] = (XpandParsersym.TK_literal);
	  
	
        //
        // Rule 113:  QVTOKeyWord ::= o r d e r e d
        //
		keywordKind[113] = (XpandParsersym.TK_ordered);
	  
	
        //
        // Rule 114:  QVTOKeyWord ::= p r i m i t i v e
        //
		keywordKind[114] = (XpandParsersym.TK_primitive);
	  
	
        //
        // Rule 115:  QVTOKeyWord ::= r a i s e
        //
		keywordKind[115] = (XpandParsersym.TK_raise);
	  
	
        //
        // Rule 116:  QVTOKeyWord ::= r e a d o n l y
        //
		keywordKind[116] = (XpandParsersym.TK_readonly);
	  
	
        //
        // Rule 117:  QVTOKeyWord ::= r e f e r e n c e s
        //
		keywordKind[117] = (XpandParsersym.TK_references);
	  
	
        //
        // Rule 118:  QVTOKeyWord ::= t a g
        //
		keywordKind[118] = (XpandParsersym.TK_tag);
	  
	
        //
        // Rule 119:  QVTOKeyWord ::= t r y
        //
		keywordKind[119] = (XpandParsersym.TK_try);
	  
	
        //
        // Rule 120:  QVTOKeyWord ::= t y p e d e f
        //
		keywordKind[120] = (XpandParsersym.TK_typedef);
	  
	
        //
        // Rule 121:  QVTOKeyWord ::= u n l i m i t e d
        //
		keywordKind[121] = (XpandParsersym.TK_unlimited);
	  
	
        //
        // Rule 122:  KeyWord ::= I M P O R T
        //
		keywordKind[122] = (XpandParsersym.TK_IMPORT);
	
        //
        // Rule 123:  KeyWord ::= E X T E N S I O N
        //
		keywordKind[123] = (XpandParsersym.TK_EXTENSION);
	
        //
        // Rule 124:  KeyWord ::= A R O U N D
        //
		keywordKind[124] = (XpandParsersym.TK_AROUND);
	
        //
        // Rule 125:  KeyWord ::= E N D A R O U N D
        //
		keywordKind[125] = (XpandParsersym.TK_ENDAROUND);
	
        //
        // Rule 126:  KeyWord ::= D E F I N E
        //
		keywordKind[126] = (XpandParsersym.TK_DEFINE);
	
        //
        // Rule 127:  KeyWord ::= E N D D E F I N E
        //
		keywordKind[127] = (XpandParsersym.TK_ENDDEFINE);
	
        //
        // Rule 128:  KeyWord ::= E R R O R
        //
		keywordKind[128] = (XpandParsersym.TK_ERROR);
	
        //
        // Rule 129:  KeyWord ::= E X P A N D
        //
		keywordKind[129] = (XpandParsersym.TK_EXPAND);
	
        //
        // Rule 130:  KeyWord ::= F O R
        //
		keywordKind[130] = (XpandParsersym.TK_FOR);
	
        //
        // Rule 131:  KeyWord ::= S E P A R A T O R
        //
		keywordKind[131] = (XpandParsersym.TK_SEPARATOR);
	
        //
        // Rule 132:  KeyWord ::= A S
        //
		keywordKind[132] = (XpandParsersym.TK_AS);
	
        //
        // Rule 133:  KeyWord ::= I T E R A T O R
        //
		keywordKind[133] = (XpandParsersym.TK_ITERATOR);
	
        //
        // Rule 134:  KeyWord ::= F O R E A C H
        //
		keywordKind[134] = (XpandParsersym.TK_FOREACH);
	
        //
        // Rule 135:  KeyWord ::= E N D F O R E A C H
        //
		keywordKind[135] = (XpandParsersym.TK_ENDFOREACH);
	
        //
        // Rule 136:  KeyWord ::= F I L E
        //
		keywordKind[136] = (XpandParsersym.TK_FILE);
	
        //
        // Rule 137:  KeyWord ::= E N D F I L E
        //
		keywordKind[137] = (XpandParsersym.TK_ENDFILE);
	
        //
        // Rule 138:  KeyWord ::= I F
        //
		keywordKind[138] = (XpandParsersym.TK_IF);
	
        //
        // Rule 139:  KeyWord ::= E L S E I F
        //
		keywordKind[139] = (XpandParsersym.TK_ELSEIF);
	
        //
        // Rule 140:  KeyWord ::= E L S E
        //
		keywordKind[140] = (XpandParsersym.TK_ELSE);
	
        //
        // Rule 141:  KeyWord ::= E N D I F
        //
		keywordKind[141] = (XpandParsersym.TK_ENDIF);
	
        //
        // Rule 142:  KeyWord ::= L E T
        //
		keywordKind[142] = (XpandParsersym.TK_LET);
	
        //
        // Rule 143:  KeyWord ::= E N D L E T
        //
		keywordKind[143] = (XpandParsersym.TK_ENDLET);
	
        //
        // Rule 144:  KeyWord ::= P R O T E C T
        //
		keywordKind[144] = (XpandParsersym.TK_PROTECT);
	
        //
        // Rule 145:  KeyWord ::= C S T A R T
        //
		keywordKind[145] = (XpandParsersym.TK_CSTART);
	
        //
        // Rule 146:  KeyWord ::= C E N D
        //
		keywordKind[146] = (XpandParsersym.TK_CEND);
	
        //
        // Rule 147:  KeyWord ::= I D
        //
		keywordKind[147] = (XpandParsersym.TK_ID);
	
        //
        // Rule 148:  KeyWord ::= D I S A B L E
        //
		keywordKind[148] = (XpandParsersym.TK_DISABLE);
	
        //
        // Rule 149:  KeyWord ::= E N D P R O T E C T
        //
		keywordKind[149] = (XpandParsersym.TK_ENDPROTECT);
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

